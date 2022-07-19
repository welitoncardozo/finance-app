package com.higor.balanceservice.rabbitmq;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.higor.balanceservice.dto.TransacaoDto;
import com.higor.balanceservice.model.Saldo;
import com.higor.balanceservice.service.SaldoService;


@Component
public class QueueConsumer {
	
	@Autowired
	private SaldoService saldoService;

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) {
        System.out.println("Message " + fileBody);
        
        Gson gson = new Gson();
        TransacaoDto transacao = gson.fromJson(fileBody, TransacaoDto.class);
        
        List<Saldo> saldos = saldoService.findByUsuarioId(transacao.getIdUser());
        Saldo saldo = saldos.size() > 0 ? saldos.get(0) : new Saldo();
        saldo.setUsuarioId(transacao.getIdUser());
        
        BigDecimal total = saldo.getTotal() != null ? saldo.getTotal() : BigDecimal.ZERO;
        if(transacao.getTipo().equals("despesa")) {
        	total = total.subtract(transacao.getValor());
        }else {
        	total = total.add(transacao.getValor());
        }
        saldo.setTotal(total);
        	
        saldoService.save(saldo);
    }

}