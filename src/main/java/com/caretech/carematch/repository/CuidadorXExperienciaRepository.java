package com.caretech.carematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caretech.carematch.key.CuidadorXExperienciaKey;
import com.caretech.carematch.model.CuidadorXExperiencia;

@Repository
public interface CuidadorXExperienciaRepository  extends JpaRepository<CuidadorXExperiencia, CuidadorXExperienciaKey>{

}
