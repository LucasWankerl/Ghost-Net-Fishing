import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class NetzDAO {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUGeisternetze");

	// Returns a list of all nets in the database
	public List<Netz> findAll() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select a from Netz a");
		List<Netz> alleNetze = q.getResultList();
		em.close();
		return alleNetze;
	}

	// saves a net without a reference to a user
	public String saveNetzAnonym(Netz neuesNetz) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(neuesNetz);
		t.commit();
		em.close();
		return "übersicht.xhtml";
	}

	// saves a net with reference to a user
	public String saveNetz(Benutzer aktuellerBenutzer, Netz neuesNetz) {
		neuesNetz.setGemeldetVon(aktuellerBenutzer);
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(aktuellerBenutzer);
		em.merge(neuesNetz);
		t.commit();
		em.close();
		return "übersicht.xhtml";
	}

	// updates a net with reference to a user who takes care of this net
	public String saveNetzWithBerger(Benutzer aktuellerBenutzer, Netz neuesNetz) {
		neuesNetz.setBerger(aktuellerBenutzer);
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(aktuellerBenutzer);
		em.merge(neuesNetz);
		t.commit();
		em.close();
		return "übersicht.xhtml";
	}

	public String deleteNetz(Netz netz) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Netz netzl = em.find(Netz.class, netz.getId());
		t.begin();
		em.remove(netzl);
		t.commit();
		em.close();
		return "verwaltung.xhtml";
	}
}
