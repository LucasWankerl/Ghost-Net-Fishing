import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class Netzliste implements Serializable {

	private static Netzliste instance = new Netzliste();
	private List<Netz> alleNetze = new ArrayList<Netz>();
	private NetzDAO netzDao;

	public Netzliste() {
		netzDao = new NetzDAO();
	}

	public List<Netz> getAlleNetze() {
		alleNetze = netzDao.findAll();
		return alleNetze;
	}

	public Netzliste getInstance() {
		return instance;
	}

	public NetzDAO getNetzDao() {
		return netzDao;
	}
}
