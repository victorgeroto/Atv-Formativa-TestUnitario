package com.AtvFormativa.entites;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.AtvFormativa.entites.Produto;

class ProdutoTest {
	
	private Produto produto;
	
	@BeforeEach
	void setUp() {
		
		produto = new Produto (1L, "FACA", "afiada", 10.0);
		
	}
	
	@Test
	@DisplayName("Testando o getter  e setter do campo ID")
	void testId() {
		produto.setId(2L);
		assertEquals(2L, produto.getId());
	}

	@Test
	@DisplayName("Testando o getter  e setter do campo Nome")
	void testNome() {
		produto.setNome("FACA");
		assertEquals("FACA", produto.getNome());
	}

	@Test
	@DisplayName("Testando o getter  e setter do campo Descicao")
	void testDescricao() {
		produto.setDescricao("afiada");
		assertEquals("afiada", produto.getDescricao());
	}
	@Test
	@DisplayName("Testando o getter  e setter do campo Preco")
	void testPreco() {
		produto.setPreco(10.0);
		assertEquals(10.0, produto.getPreco());
	}
	@Test
	@DisplayName("Testando o Construtor com todos os argumentos")
	void testConstrutorAll () {
		Produto novoProduto = new Produto (3, "relogio", "conta as horas", 90.0);
		assertAll("novoHospede",
			()-> assertEquals(3, novoProduto.getId()),
			()-> assertEquals("relogio", novoProduto.getNome()),
			()-> assertEquals("conta as horas", novoProduto.getDescricao()),
			()-> assertEquals(90.0, novoProduto.getPreco()));
	}
}


