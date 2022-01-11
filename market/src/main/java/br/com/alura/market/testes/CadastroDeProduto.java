package br.com.alura.market.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.market.dao.CategoriaDAO;
import br.com.alura.market.dao.ProdutoDAO;
import br.com.alura.market.modelo.Categoria;
import br.com.alura.market.modelo.Produto;
import br.com.alura.market.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.geEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		Produto p = produtoDAO.buscaPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos =produtoDAO.buscarPorNomeDaCategoria("CELULARES");
		todos.forEach(p2 -> System.out.println(p.getNome()));
		
		BigDecimal precoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("Xiaomi");
		System.out.println("Preco do Produto: " + precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiaomi","bom",new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.geEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}

}
