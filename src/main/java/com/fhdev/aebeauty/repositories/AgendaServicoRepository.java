package com.fhdev.aebeauty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fhdev.aebeauty.domain.AgendaServico;

@Repository
public interface AgendaServicoRepository extends JpaRepository<AgendaServico, Integer>{

}
