package com.caretech.carematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caretech.carematch.model.Cuidador;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Integer>{

}
