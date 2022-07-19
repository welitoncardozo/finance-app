const express = require('express');
const cors = require('cors');
const app = express();
const mongoose = require("mongoose");
const bodyParser = require('body-parser');
const amqplib = require('amqplib/callback_api')

const host = 'localhost';
const queueName = 'transacoes'
let channel = null;

mongoose.Promise = global.Promise;
mongoose.connect(`mongodb://${host}:27017/transactions`);
const TransactionModel = mongoose.model("Transaction", new mongoose.Schema({
    idUser: Number,
    valor: Number,
    tipo: String
}));

amqplib.connect(`amqp://${host}:5672`, (err, connection) => {
    if (err) {
        throw err
    }
    connection.createChannel((err, newChannel) => {
        if (err) {
            throw err;
        }
        newChannel.assertQueue(queueName)
        channel = newChannel
        console.log('Connectado ao RabbitMQ!');
    });
});

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(cors());
app.use(express.json());
app.listen(3000);

app.post('/transaction', (req, res) => {
    let transaction = new TransactionModel(req.body);
    transaction.save()
        .then(transacao => {
            const transacaoJson = JSON.stringify(transacao);
            channel.sendToQueue(queueName, Buffer.from(transacaoJson));
            console.log('Transação enviada para fila!')
            return res.json(transacao);
        })
        .catch(err => {
            res.status(400).send(err);
        });
})