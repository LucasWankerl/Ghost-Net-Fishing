import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Benutzerliste implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Benutzerliste instance = new Benutzerliste();
	private List<Benutzer> alleBenutzer = new ArrayList<Benutzer>();
	protected BenutzerDAO benutzerDao;

	public Benutzerliste() {
		benutzerDao = new BenutzerDAO();
	}

	public List<Benutzer> getAlleBenutzer() {
		return benutzerDao.getAll();
	}

	public Benutzerliste getInstance() {
		return instance;
	}
}
