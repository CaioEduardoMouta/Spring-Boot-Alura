package br.com.alura.market.dao;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import br.com.alura.market.modelo.Categoria;
import br.com.alura.market.modelo.Cliente;
import br.com.alura.market.modelo.ItemPedido;
import br.com.alura.market.modelo.Pedido;
import br.com.alura.market.modelo.Produto;
import br.com.alura.market.util.JPAUtil;

public class PerformanceConsultas {
	
	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.geEntityManager();
		Pedido pedido = em.find(Pedido.class, 1l);
		System.out.println(pedido.getItens().size());
	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi","bom",new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5","Playstation 5",new BigDecimal("800"), videogames);
		Produto lenovo = new Produto("Lenovo","lenovo",new BigDecimal("800"), informatica);

		Cliente cliente = new Cliente("Caio","234232");
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10,pedido,celular));
		pedido.adicionarItem(new ItemPedido(10,pedido,videogame));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(2,pedido, lenovo));
		
		
		EntityManager em = JPAUtil.geEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		PedidoDAO pedidoDAO = new PedidoDAO(em);
	}

}
