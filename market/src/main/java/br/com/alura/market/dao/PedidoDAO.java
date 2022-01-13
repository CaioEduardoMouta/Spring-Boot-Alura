package br.com.alura.market.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.market.modelo.Pedido;
import br.com.alura.market.modelo.Produto;
import br.com.alura.market.vo.RelatorioDeVendasVo;

public class PedidoDAO {
	
	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) from Pedido p";
		return em.createQuery(jpql, BigDecimal.class)
				.getSingleResult();
	}
	
	public List<RelatorioDeVendasVo> relatorioDeVendas() {
		String jpql = "Select new br.com.alura.market.vo.RelatorioDeVendasVo,("
				+ "SUM(item.quantidade), "
				+ "MAX(pedido.data))"
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto"
				+ "GROUP BY produto.nome"
				+ "ORDER BY item.quantidade DESC";
		return em.createQuery(jpql, RelatorioDeVendasVo.class)
				.getResultList();
				
	}
	
	
	
}