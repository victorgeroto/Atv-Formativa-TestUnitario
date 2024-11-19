package com.AtvFormativa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AtvFormativa.entites.Produto;
import com.AtvFormativa.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	@Autowired
    ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }
    
    public Produto atualizarProduto (Produto produto) {
    	if(produtoRepository.existsById(produto.getId())){
    		return produtoRepository.save(produto);
    	}else {
    		throw new RuntimeException("Produto não");
    	}
    }
    
    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}