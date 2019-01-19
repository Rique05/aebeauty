package com.fhdev.aebeauty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fhdev.aebeauty.domain.CompraProduto;

@Repository
public interface CompraProdutoRepository extends JpaRepository<CompraProduto, Integer>{

}
