package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Cuenta;

public interface CuentaService {
	
	public Iterable<Cuenta> findAll();

	public Optional<Cuenta> findById(Long id);
	
	public Cuenta save(Cuenta cuenta);
	
	public void deleteById(Long id);
	
}
