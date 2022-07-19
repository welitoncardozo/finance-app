package com.higor.balanceservice.service;

import com.higor.balanceservice.model.Saldo;

import java.util.Optional;

public interface SaldoService extends GenericService<Saldo> {
	Optional<Saldo> findByUsuarioId(final Integer userId);
}
