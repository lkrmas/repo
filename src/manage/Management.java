package manage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Management {

	public void createNewDB() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("DROP SCHEMA PUBLIC CASCADE").executeUpdate();
		em.createNativeQuery("CREATE TABLE guard (id IDENTITY, name VARCHAR(50), age INT);").executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new Management().createNewDB();
	}

}
