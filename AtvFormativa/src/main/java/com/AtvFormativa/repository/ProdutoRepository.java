package com.AtvFormativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AtvFormativa.entites.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

}

