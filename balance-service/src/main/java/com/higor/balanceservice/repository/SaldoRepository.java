package com.higor.balanceservice.repository;

import java.util.List;

import com.higor.balanceservice.model.Saldo;

public interface SaldoRepository extends GenericRepository<Saldo> {

	List<Saldo> findByUsuarioId(Integer usuarioId);

}
