package com.higor.balanceservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.higor.balanceservice.model.Saldo;
import com.higor.balanceservice.repository.SaldoRepository;
import com.higor.balanceservice.service.SaldoService;

@Service
public class SaldoServiceImpl extends GenericServiceImpl<Saldo, SaldoRepository> implements SaldoService {

	public List<Saldo> findByUsuarioId(Integer usuarioId) {
		return getRepository().findByUsuarioId(usuarioId);
	}
	
}
