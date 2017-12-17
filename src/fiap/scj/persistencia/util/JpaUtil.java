package fiap.scj.persistencia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividade3");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
