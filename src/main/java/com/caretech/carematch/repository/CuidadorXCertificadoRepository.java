package com.caretech.carematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caretech.carematch.key.CuidadorXCertificadoKey;
import com.caretech.carematch.model.CuidadorXCertificado;

@Repository
public interface CuidadorXCertificadoRepository extends JpaRepository<CuidadorXCertificado, CuidadorXCertificadoKey> {

}
