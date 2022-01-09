package br.com.alura.market.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.market.dao.CategoriaDAO;
import br.com.alura.market.dao.ProdutoDAO;
import br.com.alura.market.modelo.Categoria;
import br.com.alura.market.modelo.Produto;
import br.com.alura.market.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiami","bom",new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.geEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
		
		
	}

}
