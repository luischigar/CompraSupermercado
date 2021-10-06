package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Transaccion;


public interface TransaccionService {
	
	public Iterable<Transaccion> findAll();

	public Optional<Transaccion> findById(Long id);
	
	public Transaccion save(Transaccion cuenta);
	
	public void deleteById(Long id);
}
