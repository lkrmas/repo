package manage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/db", loadOnStartup = 0)
public class Management extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static EntityManagerFactory emf;
    private EntityManager em;

    private static void Construct() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("PU");
        }
    }

    private static void Destruct() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

    public static EntityManager NewEntityManager() {
        Construct();
        return emf.createEntityManager();
    }

    public void initiate() {
        Construct();
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void dropOldDB() {
        em.createNativeQuery("DROP SCHEMA PUBLIC CASCADE").executeUpdate();
    }

    public void createNewDB() {
        @SuppressWarnings("unchecked")
        ArrayList<Object> schema = (ArrayList<Object>) em.createNativeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC' AND TABLE_NAME = 'ID'").getResultList();
        if (schema.isEmpty()) {
            em.createNativeQuery("CREATE TABLE ID (ID IDENTITY)").executeUpdate();
            em.createNativeQuery("CREATE TABLE guard (id IDENTITY, name VARCHAR(50), age INT);").executeUpdate();
            em.createNativeQuery("CREATE TABLE incident (id IDENTITY, open DATE, close DATE, location VARCHAR(50), description VARCHAR(50), involvedGuardCount INT, status VARCHAR(50));").executeUpdate();
        }
    }

    public void terminate() {
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {
        Management m = new Management();
        m.initiate();
        m.dropOldDB();
        m.createNewDB();
        m.terminate();
        Destruct();
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
        Destruct();
    }

}
