import { Router } from 'express';
import { createMessageChannel } from '../messages/messageChannel';
import { Transacao } from '../models/TransacaoModel';
import TransacaoController from '../controller/TransacaoController';

export const transacaoRouter = Router();
const transacaoCtrl = new TransacaoController();

transacaoRouter.post('/transacao', async (req, res) => {
    const transacao: Transacao = req.body;
    const transacaoSalva = await transacaoCtrl.save(transacao);

    const messageChannel = await createMessageChannel();

    if (messageChannel) {
        const transacaoJson = JSON.stringify(transacao);
        messageChannel.sendToQueue(process.env.QUEUE_NAME, Buffer.from(transacaoJson));
        console.log('Transacao enviada para fila');
    }

    return res.json(transacaoSalva);
})