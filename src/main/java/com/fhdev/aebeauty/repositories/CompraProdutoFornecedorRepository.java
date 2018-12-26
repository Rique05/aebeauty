package com.fhdev.aebeauty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fhdev.aebeauty.domain.CompraProdutoFornecedor;

@Repository
public interface CompraProdutoFornecedorRepository extends JpaRepository<CompraProdutoFornecedor, Integer>{

}
