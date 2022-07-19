package com.higor.balanceservice.controller;

import com.higor.balanceservice.model.Saldo;
import com.higor.balanceservice.service.SaldoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/balance-service")
public class BalanceController {
	private final SaldoService balanceService;

	public BalanceController(SaldoService balanceService) {
		this.balanceService = balanceService;
	}

	@GetMapping
	public List<Saldo> getAll() {
		return balanceService.findAll();
	}

	@GetMapping("/{userId}")
	public Saldo getAll(@PathVariable final Integer userId) {
		return balanceService.findByUsuarioId(userId)
				.orElse(null);
	}
}
