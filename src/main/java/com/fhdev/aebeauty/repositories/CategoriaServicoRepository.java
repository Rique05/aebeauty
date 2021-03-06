package com.fhdev.aebeauty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fhdev.aebeauty.domain.CategoriaServico;

@Repository
public interface CategoriaServicoRepository extends JpaRepository<CategoriaServico, Integer>{

}
