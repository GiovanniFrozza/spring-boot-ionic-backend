package com.giovanniEstudo.cursoMC;

import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import com.giovanniEstudo.cursoMC.Entities.CidadeEntity;
import com.giovanniEstudo.cursoMC.Entities.EstadoEntity;
import com.giovanniEstudo.cursoMC.Entities.ProdutoEntity;
import com.giovanniEstudo.cursoMC.repositories.CategoriaRepository;
import com.giovanniEstudo.cursoMC.repositories.CidadeRepository;
import com.giovanniEstudo.cursoMC.repositories.EstadoRepository;
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

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Instanciando categorias
		CategoriaEntity categoria1 = new CategoriaEntity(null, "Informatica");
		CategoriaEntity categoria2 = new CategoriaEntity(null, "Escritorio");

		//Instanciando produtos
		ProdutoEntity produto1 = new ProdutoEntity(null, "Computador", 2000.00);
		ProdutoEntity produto2 = new ProdutoEntity(null, "Impressora", 800.00);
		ProdutoEntity produto3 = new ProdutoEntity(null, "Mouse", 80.00);

		//categorias tem x produtos -------- Adicionando na Lista relacionada
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().add(produto2);

		//produtos tem x categoria
		produto1.getCategorias().add(categoria1);
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().add(categoria1);

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

		//Instanciando estados
		EstadoEntity estado1 = new EstadoEntity(null, "Minas Gerais");
		EstadoEntity estado2 = new EstadoEntity(null, "Sao Paulo");

		//Instanciando cidades
		CidadeEntity cidade1 = new CidadeEntity(null, "Uberlandia", estado1);
		CidadeEntity cidade2 = new CidadeEntity(null, "Sao Paulo", estado2);
		CidadeEntity cidade3 = new CidadeEntity(null, "Campinas", estado2);

		//estado tem x cidades -------- Adicionando na Lista relacionada
		estado1.getCidades().add(cidade1);
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));


	}
}
