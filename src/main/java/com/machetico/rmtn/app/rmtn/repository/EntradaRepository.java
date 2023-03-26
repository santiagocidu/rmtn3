package com.machetico.rmtn.app.rmtn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.machetico.rmtn.app.rmtn.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {

}
