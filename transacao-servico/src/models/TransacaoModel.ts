import { model, Document, Schema } from 'mongoose';

export interface Transacao extends Document {
    idUser: number
    valor: number
    tipo: string
}

const schema = new Schema<Transacao>({
    idUser: { type: Number, required: true },
    valor: { type: Number, required: true },
    tipo: { type: String, required: true }
});

export const TransacaoModel = model<Transacao>('Transacao', schema);