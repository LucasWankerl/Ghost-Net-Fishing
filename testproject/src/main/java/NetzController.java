import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class NetzController implements Serializable {
	@Inject
	Netzliste netzliste;

	private int index = 0;
	private int size;
	private Netz neuesNetz = new Netz();
	private boolean netzBergen = false;

	public Netz getNeuesNetz() {
		return neuesNetz;
	}

	public void setNeuesNetz(Netz neuesNetz) {
		this.neuesNetz = neuesNetz;
	}

	public Netz getNetz() {
		return netzliste.getAlleNetze().get(index);
	}

	public void vor() {
		if (index < netzliste.getAlleNetze().size() - 1) {
			index++;
		}
	}

	public void zurueck() {
		if (index > 0) {
			index--;
		}
	}

	public int getIndex() {
		return index;
	}

	public int getSize() {
		return netzliste.getAlleNetze().size();
	}

	public boolean isNetzBergen() {
		return netzBergen;
	}

	public void setNetzBergen(boolean netzBergen) {
		this.netzBergen = netzBergen;
	}
}