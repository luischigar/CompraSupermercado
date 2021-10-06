package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DateRan;
import com.example.demo.entity.Transaccion;
import com.example.demo.service.TransaccionService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/transaccioneDateRan")
public class TransaccionDateRanController {
	
	@Autowired
	private TransaccionService transaccionService;
	
	@PostMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody DateRan dateRangrUpdate, @PathVariable(value = "id") Long id){
		
		List<Transaccion> lisTransacccion = StreamSupport
				.stream(transaccionService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		for (int i = 0; i < lisTransacccion.size(); i++) {
			Long f = lisTransacccion.get(i).getIdcuenta();
			if(id == f) {
				if(!(lisTransacccion.get(i).getFecha().before(dateRangrUpdate.getFechaInicio()) && lisTransacccion.get(i).getFecha().after(dateRangrUpdate.getFechaFin()))) {
					long g = lisTransacccion.get(i).getId();
					Optional<Transaccion> oTransaccion = transaccionService.findById(g);
					return ResponseEntity.ok(oTransaccion);
				}
			}
		}
		
		return ResponseEntity.notFound().build();
	}

}
