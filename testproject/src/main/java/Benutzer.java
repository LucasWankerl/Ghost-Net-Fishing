import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "benutzer")
public class Benutzer {
	@Id
	@Column(name = "benutzername")
	private String name;
	@Column(name = "passwort")
	private String passwort;
	@Column(name = "telefonnummer")
	private String telefonnummer;
	@Column(name = "istBerger")
	private boolean isBerger;

	public Benutzer() {
	}

	public Benutzer(String name, String passwort, String telefonnummer, boolean isBerger) {
		super();
		this.name = name;
		this.passwort = passwort;
		this.telefonnummer = telefonnummer;
		this.isBerger = isBerger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public boolean isBerger() {
		return isBerger;
	}

	public void setBerger(boolean isBerger) {
		this.isBerger = isBerger;
	}

	public boolean getIsBerger() {
		return isBerger;
	}

	public void setIsBerger(boolean isBerger) {
		this.isBerger = isBerger;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Benutzer) {
			Benutzer b = (Benutzer) obj;
			if (b.getName().equals(this.name) && b.getPasswort().equals(this.passwort)) {
				return true;
			}
		}
		return false;
	}

}
