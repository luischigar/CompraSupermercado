package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cuenta;
import com.example.demo.service.CuentaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/cuentas")
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cuenta cuenta){
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.save(cuenta));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cuenta cuentaUpdate, @PathVariable(value = "id") Long id){
		Optional<Cuenta> oCuenta = cuentaService.findById(id);
		
		if(!oCuenta.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oCuenta.get().setDescripcion(cuentaUpdate.getDescripcion());
		oCuenta.get().setDireccion(cuentaUpdate.getDireccion());
		oCuenta.get().setEstado(cuentaUpdate.getEstado());
		oCuenta.get().setIduser(cuentaUpdate.getIduser());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.save(oCuenta.get()));
	}
	
	@GetMapping
	public List<Cuenta> readAll(){
		List<Cuenta> lisCuenta = StreamSupport
				.stream(cuentaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return lisCuenta;
	}

}
