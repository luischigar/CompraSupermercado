package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transaccion;
import com.example.demo.repository.TransaccionRepository;

@Service
public class TransaccionServiceImpl implements TransaccionService{
	
	@Autowired
	private TransaccionRepository transaccionRepository;

	@Override
	public Iterable<Transaccion> findAll() {
		return transaccionRepository.findAll();
	}

	@Override
	public Optional<Transaccion> findById(Long id) {
		return transaccionRepository.findById(id);
	}

	@Override
	public Transaccion save(Transaccion transaccion) {
		return transaccionRepository.save(transaccion);
	}

	@Override
	public void deleteById(Long id) {
		transaccionRepository.deleteById(id);
	}

	
}
