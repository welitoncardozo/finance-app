package com.higor.balanceservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.higor.balanceservice.service.GenericService;

public abstract class AbstractController<E, S extends GenericService<E>> {

	private final S service;
	private final Class<E> entityClass;

	public AbstractController(S service, Class<E> entityClass) {
		this.service = service;
		this.entityClass = entityClass;
	}

	public S getService() {
		return service;
	}

	@GetMapping("/lista")
	public List<E> getAll(HttpServletRequest request) {
		return service.findAll();
	}

	@GetMapping
	public Page<E> getAll(Pageable pageable, HttpServletRequest request) { 
		return service.findAll(pageable);
	}

	@GetMapping("/{id}")
	public E findById(@PathVariable Long id, HttpServletRequest request) {
		return service.findById(id).orElse(null);
	}

	@PostMapping
	public E save(@Valid @RequestBody E entity, HttpServletRequest request) {
		return service.save(entity);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id, HttpServletRequest request) {
		service.deleteById(id);
	}

}
