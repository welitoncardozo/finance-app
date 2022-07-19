import { Transacao, TransacaoModel } from "../models/TransacaoModel";

export default class TransacaoController {
    async save(transacao: Transacao): Promise<Transacao> {
        const novaTransacao = await TransacaoModel.create(transacao);
        return novaTransacao;
    }

}