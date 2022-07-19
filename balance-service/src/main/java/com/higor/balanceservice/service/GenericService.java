package com.higor.balanceservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<T> {

	List<T> findAll();

	Page<T> findAll(Pageable pageable);

	T save(T entity);

	Optional<T> findById(Long id);

	void deleteById(Long id);

}
