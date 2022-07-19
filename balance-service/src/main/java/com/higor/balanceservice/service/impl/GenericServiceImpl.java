package com.higor.balanceservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.higor.balanceservice.repository.GenericRepository;
import com.higor.balanceservice.service.GenericService;

public abstract class GenericServiceImpl<T, R extends GenericRepository<T>> implements GenericService<T> {

	@Autowired
	protected R repository;

	public R getRepository() {
		return repository;
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public Optional<T> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
