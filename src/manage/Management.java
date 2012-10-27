package manage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/db", loadOnStartup = 0)
public class Management extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EntityManagerFactory emf;
	private EntityManager em;

	public void initiate() {
		emf = Persistence.createEntityManagerFactory("PU");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	public void dropOldDB() {
		em.createNativeQuery("DROP SCHEMA PUBLIC CASCADE").executeUpdate();
	}

	public void createNewDB() {
		try {
			em.createNativeQuery("CREATE TABLE guard (id IDENTITY, name VARCHAR(50), age INT);").executeUpdate();
		}
		catch (Exception e) {
		}
	}

	public void terminate() {
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		Management m = new Management();
		m.initiate();
		m.dropOldDB();
		m.createNewDB();
		m.terminate();
	}

	public void init() throws ServletException {
		initiate();
		createNewDB();
		terminate();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initiate();
		dropOldDB();
		createNewDB();
		terminate();
	}

	public void destroy() {
	}

}
