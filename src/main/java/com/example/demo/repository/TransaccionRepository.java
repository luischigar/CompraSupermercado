package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Transaccion;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{

}
