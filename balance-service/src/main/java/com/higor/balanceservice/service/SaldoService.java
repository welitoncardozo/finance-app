package com.higor.balanceservice.service;

import java.util.List;

import com.higor.balanceservice.model.Saldo;

public interface SaldoService extends GenericService<Saldo> {

	List<Saldo> findByUsuarioId(Integer usuarioId);
	
}
