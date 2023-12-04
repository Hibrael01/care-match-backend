package com.caretech.carematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caretech.carematch.key.EnderecoProcuradorKey;
import com.caretech.carematch.model.EnderecoProcurador;

@Repository
public interface EnderecoProcuradorRepository extends JpaRepository<EnderecoProcurador, EnderecoProcuradorKey>{

}
