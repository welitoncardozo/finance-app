package com.higor.balanceservice.service.impl;

import com.higor.balanceservice.model.Saldo;
import com.higor.balanceservice.repository.SaldoRepository;
import com.higor.balanceservice.service.SaldoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaldoServiceImpl extends GenericServiceImpl<Saldo, SaldoRepository> implements SaldoService {
	public Optional<Saldo> findByUsuarioId(final Integer userId) {
		return getRepository().findByUsuarioId(userId);
	}
}
