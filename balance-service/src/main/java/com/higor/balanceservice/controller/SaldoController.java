package com.higor.balanceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.higor.balanceservice.model.Saldo;
import com.higor.balanceservice.service.SaldoService;

@RestController
@RequestMapping("/saldo")
public class SaldoController extends AbstractController<Saldo, SaldoService> {

	@Autowired
	public SaldoController(SaldoService service) {
		super(service, Saldo.class);
	}

	@PostMapping("/salvar")
	public Long salvar(@RequestBody Saldo local) {
		return getService().save(local).getId();
	}

	@GetMapping(value = "/pagina-filtrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Saldo> paginaFiltrar(@RequestParam String id, @RequestParam String nome,
			@PageableDefault(page = 0, size = 100) Pageable paginacao) {
		return getService().findAll(paginacao);
	}

}
