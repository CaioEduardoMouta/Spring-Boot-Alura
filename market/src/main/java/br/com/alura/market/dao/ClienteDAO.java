package br.com.alura.market.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.market.modelo.Cliente;
import br.com.alura.market.modelo.Pedido;
import br.com.alura.market.modelo.Produto;

public class ClienteDAO {
	
	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
}