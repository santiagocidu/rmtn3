package com.machetico.rmtn.app.rmtn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.machetico.rmtn.app.rmtn.model.Empresa_proveedora;

@Repository
public interface Empresa_ProveedoraRepository extends JpaRepository<Empresa_proveedora, Long> {

}
