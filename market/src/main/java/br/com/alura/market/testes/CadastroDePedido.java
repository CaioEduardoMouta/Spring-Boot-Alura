package br.com.alura.market.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.market.dao.CategoriaDAO;
import br.com.alura.market.dao.ClienteDAO;
import br.com.alura.market.dao.PedidoDAO;
import br.com.alura.market.dao.ProdutoDAO;
import br.com.alura.market.modelo.Categoria;
import br.com.alura.market.modelo.Cliente;
import br.com.alura.market.modelo.ItemPedido;
import br.com.alura.market.modelo.Pedido;
import br.com.alura.market.modelo.Produto;
import br.com.alura.market.util.JPAUtil;
import br.com.alura.market.vo.RelatorioDeVendasVo;

public class CadastroDePedido {
	
	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.geEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		
		Produto produto = produtoDAO.buscaPorId(1l);
		Cliente cliente = clienteDao.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido());
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		pedidoDAO.cadastrar(pedido);
		
		em.getTransaction().commit();

		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("Valor total " +totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDAO.relatorioDeVendas();
		relatorio.forEach(System.out::println);
	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi","bom",new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5","Playstation 5",new BigDecimal("800"), videogames);
		Produto lenovo = new Produto("Lenovo","lenovo",new BigDecimal("800"), informatica);

		Cliente cliente = new Cliente("Caio","234232");
		
		EntityManager em = JPAUtil.geEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(videogames);
		categoriaDAO.cadastrar(informatica);
		produtoDAO.cadastrar(celular);
		clienteDAO.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}
