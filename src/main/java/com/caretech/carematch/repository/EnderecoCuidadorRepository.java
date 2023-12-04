package com.caretech.carematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caretech.carematch.key.EnderecoCuidadorKey;
import com.caretech.carematch.model.EnderecoCuidador;

@Repository
public interface EnderecoCuidadorRepository extends JpaRepository<EnderecoCuidador, EnderecoCuidadorKey> {

}
