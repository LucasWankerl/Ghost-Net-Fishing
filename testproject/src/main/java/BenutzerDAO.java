import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BenutzerDAO {
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUGeisternetze");

	public void saveBenutzer(Benutzer neuerBenutzer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(neuerBenutzer);
		t.commit();
		em.close();
	}

	public void createBenutzer(Benutzer neuerBenutzer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(neuerBenutzer);
		t.commit();
		em.close();
	}

	public List<Benutzer> getAll() {
		List<Benutzer> alleBenutzer = new ArrayList<Benutzer>();
		EntityManager em = emf.createEntityManager();
		Query qb = em.createQuery("select a from Benutzer a");
		alleBenutzer = qb.getResultList();
		em.close();
		return alleBenutzer;
	}
}
