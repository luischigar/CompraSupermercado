package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cuenta;
import com.example.demo.service.CuentaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/cuentaIdUser")
public class CuentaIdUser {
	
	@Autowired
	private CuentaService cuentaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long id){
		List<Cuenta> lisCuenta = StreamSupport
				.stream(cuentaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		for (int i = 0; i < lisCuenta.size(); i++) {
			Long f = lisCuenta.get(i).getIduser();
			if(id == f) {
				long g = lisCuenta.get(i).getId();
				Optional<Cuenta> oCuenta = cuentaService.findById(g);
				return ResponseEntity.ok(oCuenta);
			}
		}
		return ResponseEntity.notFound().build();
	}
}
