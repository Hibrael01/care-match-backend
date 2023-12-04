package com.caretech.carematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caretech.carematch.key.CuidadorXDisponibilidadeKey;
import com.caretech.carematch.model.CuidadorXDisponibilidade;

@Repository
public interface CuidadorXDisponibilidadeRepository  extends JpaRepository<CuidadorXDisponibilidade, CuidadorXDisponibilidadeKey>{

}
