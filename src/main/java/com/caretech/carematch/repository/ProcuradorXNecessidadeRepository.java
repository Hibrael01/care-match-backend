package com.caretech.carematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caretech.carematch.key.ProcuradorXNecessidadeKey;
import com.caretech.carematch.model.ProcuradorXNecessidade;

@Repository
public interface ProcuradorXNecessidadeRepository extends JpaRepository<ProcuradorXNecessidade, ProcuradorXNecessidadeKey> {

}
