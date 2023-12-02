package com.caretech.carematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caretech.carematch.model.Procurador;

@Repository
public interface ProcuradorRepository  extends JpaRepository<Procurador, Integer>{

}
