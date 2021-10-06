package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Cuenta;
import com.example.demo.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Cuenta> findAll() {
		return cuentaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cuenta> findById(Long id) {
		return cuentaRepository.findById(id);
	}

	@Override
	@Transactional
	public Cuenta save(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		cuentaRepository.deleteById(id);
	}

}
