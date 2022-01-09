package br.com.alura.market.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence
			.createEntityManagerFactory("market");
	
	public static EntityManager geEntityManager() {
		return FACTORY.createEntityManager();
	}

}
