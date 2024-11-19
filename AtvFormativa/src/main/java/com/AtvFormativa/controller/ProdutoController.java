package com.AtvFormativa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AtvFormativa.entites.Produto;
import com.AtvFormativa.service.ProdutoService;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {
    
	private final ProdutoService produtoService;

    @Autowired // Injeção de dependencia por construtor
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto createProduct(@RequestBody Produto produto) {
        return produtoService.saveProduto(produto);
    }

    @GetMapping("/{id}")
    public Optional<Produto> getProduto(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
    }
}