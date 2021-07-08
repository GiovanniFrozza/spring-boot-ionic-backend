package com.giovanniEstudo.cursoMC;

import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import com.giovanniEstudo.cursoMC.Entities.ProdutoEntity;
import com.giovanniEstudo.cursoMC.repositories.CategoriaRepository;
import com.giovanniEstudo.cursoMC.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CategoriaEntity categoria1 = new CategoriaEntity(null, "Informatica");
		CategoriaEntity categoria2 = new CategoriaEntity(null, "Escritorio");

		ProdutoEntity produto1 = new ProdutoEntity(null, "Computador", 2000.00);
		ProdutoEntity produto2 = new ProdutoEntity(null, "Impressora", 800.00);
		ProdutoEntity produto3 = new ProdutoEntity(null, "Mouse", 80.00);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

	}
}
