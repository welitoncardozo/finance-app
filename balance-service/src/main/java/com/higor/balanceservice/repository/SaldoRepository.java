package com.higor.balanceservice.repository;

import com.higor.balanceservice.model.Saldo;

import java.util.Optional;

public interface SaldoRepository extends GenericRepository<Saldo> {
	Optional<Saldo> findByUsuarioId(final Integer userId);
}
