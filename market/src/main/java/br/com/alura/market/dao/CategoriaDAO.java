package br.com.alura.market.dao;

import javax.persistence.EntityManager;

import br.com.alura.market.modelo.Categoria;


public class CategoriaDAO {
	
	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
}
