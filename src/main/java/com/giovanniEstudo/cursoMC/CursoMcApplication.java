package com.giovanniEstudo.cursoMC;

import com.giovanniEstudo.cursoMC.Entities.*;
import com.giovanniEstudo.cursoMC.enums.EstadoPagamentoEnum;
import com.giovanniEstudo.cursoMC.enums.TipoClienteEnum;
import com.giovanniEstudo.cursoMC.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Instanciando categorias
		CategoriaEntity categoria1 = new CategoriaEntity(null, "Informatica");
		CategoriaEntity categoria2 = new CategoriaEntity(null, "Escritorio");
		CategoriaEntity categoria3 = new CategoriaEntity(null, "Cama mesa e banho");
		CategoriaEntity categoria4 = new CategoriaEntity(null, "Eletronico");
		CategoriaEntity categoria5 = new CategoriaEntity(null, "Jardinagem");
		CategoriaEntity categoria6 = new CategoriaEntity(null, "Decoracao");
		CategoriaEntity categoria7 = new CategoriaEntity(null, "Perfumaria");

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

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4, categoria5, categoria6, categoria7));
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

		//Instanciando cliente
		ClienteEntity cliente1 = new ClienteEntity(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoClienteEnum.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		//Instanciando endereco
		EnderecoEntity endereco1 = new EnderecoEntity(null, "Rua Flores", "300", "Apto 303", "Jardim","38220834",cliente1,cidade1);
		EnderecoEntity endereco2 = new EnderecoEntity(null, "Avenida Matos", "105", "Sala 800", "Centro","38777012",cliente1,cidade2);

		//cliente tem x enderecos -------- Adicionando na Lista relacionada
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));

		clienteRepository.save(cliente1);
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));

		//Instanciando Pedido;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		PedidoEntity pedido1 = new PedidoEntity(null, sdf.parse("30/09/2017 10:32"), cliente1, endereco1);
		PedidoEntity pedido2 = new PedidoEntity(null, sdf.parse("10/10/2017 19:37"), cliente1, endereco2);

		PagamentoEntity pagamento1 = new PagamentoComCartaoEntity(null, EstadoPagamentoEnum.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);

		PagamentoEntity pagamento2 = new PagamentoComBoletoEntity(null, EstadoPagamentoEnum.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null );
		pedido2.setPagamento(pagamento2);

		//cliente tem x pedidos -------- Adicionando na Lista relacionada
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));

		//Instanciando ItemPedido
		ItemPedidoEntity itemPedido1 = new ItemPedidoEntity(pedido1, produto1, 0.00, 1, 2000.00);
		ItemPedidoEntity itemPedido2 = new ItemPedidoEntity(pedido1, produto3, 0.00, 2, 80.00);
		ItemPedidoEntity itemPedido3 = new ItemPedidoEntity(pedido2, produto2, 100.00, 1, 800.00);

		//pedido tem x itens -------- Adicionando na Lista relacionada
		pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
		pedido2.getItens().add(itemPedido3);

		//produto tem x itemPedido -------- Adicionando na Lista relacionada
		produto1.getItens().add(itemPedido1);
		produto2.getItens().add(itemPedido3);
		produto3.getItens().add(itemPedido2);

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));




	}
}
