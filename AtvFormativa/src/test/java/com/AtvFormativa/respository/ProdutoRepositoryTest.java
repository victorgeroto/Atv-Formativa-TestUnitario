package com.AtvFormativa.respository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.AtvFormativa.entites.Produto;
import com.AtvFormativa.repository.ProdutoRepository;

@DataJpaTest
class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;

	@DisplayName("Testando o Save")
	@Test
	void test() {

		// Given / Arrange
		Produto produto1 = new Produto(1L, "Caneta",
				"escreve letras",
				2.0);

		// When / Act 
		Produto saveProduto = produtoRepository.save(produto1);

		//Then / Assert
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
	}

	@DisplayName("Testando Get para todos os Produtos")
	@Test
	void testGetAllRepository() {
		//given / Arrange 
		Produto Produto1 = new Produto (1L, "Caneta","escreve letras",
				2.0);
				
		Produto Produto2 = new Produto (2L, "Faca","afiada",
				9.0);
		produtoRepository.save(Produto1);
		produtoRepository.save(Produto2);

		//when / Act 
		List<Produto> produtoList =  produtoRepository.findAll();

		//then / Assert
		assertNotNull(produtoList);
		assertEquals(2, produtoList.size());
	}
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {

		//given / Arrange 
		Produto produto1 = new Produto (1L, "Caneta","escreve letras",
				2.0);
		produtoRepository.save(produto1);

		//when / Act 
		Produto saveProduto =  produtoRepository.findById(produto1.getId()).get();


		//then / Assert
		assertNotNull(saveProduto);
		assertEquals(produto1.getId(), saveProduto.getId());

	}
	@DisplayName("Testando o Update")
	@Test
	void testUpdateProduto() {
		//given / Arrange 
		Produto produto1 = new Produto (1L, "Caneta","escreve letras",
				2.0);
		produtoRepository.save(produto1);
		//when / Act 
		Produto saveProduto =  produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("Mouse");
		produto1.setPreco(250.0);
		produto1.setDescricao("Usado para navegar");


		Produto updateProduto = produtoRepository.save(saveProduto);

		//then / Assert
		assertNotNull(updateProduto);
		assertEquals("Mouse", updateProduto.getNome());
		assertEquals(250.0, updateProduto.getPreco());
		assertEquals("Usado para navegar", updateProduto.getDescricao());

	}
	@DisplayName("Testando o Delete")
	@Test
	void testDeleteProduto() {


		//given / Arrange 
		Produto Produto1 = new Produto (1L, "Caneta","escreve letras",
				2.0);
		produtoRepository.save(Produto1);
		//when / Act 
		produtoRepository.deleteById(Produto1.getId());

		Optional<Produto> produtoOptional = produtoRepository.findById(Produto1.getId());

		//then / assert

		assertTrue(produtoOptional.isEmpty());
	}

}