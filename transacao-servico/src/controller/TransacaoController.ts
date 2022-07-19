import { Transacao, TransacaoModel } from "../models/TransacaoModel";

export default class TransacaoController {
    async save(transacao: Transacao): Promise<Transacao> {
        const novaTransacao = await TransacaoModel.create(transacao);
        return novaTransacao;
    }

    async findLastTransacoes(quantidade: number): Promise<Transacao[]> {
        const ultimasTransacoes: Transacao[] =
            await TransacaoModel
                .find()
                .sort({ _id: 1 })
                .limit(quantidade);
        return ultimasTransacoes;
    }
}