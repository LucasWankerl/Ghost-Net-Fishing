import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "netz")
public class Netz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "gpsLänge")
	private double gpsLänge;
	@Column(name = "gpsBreite")
	private double gpsBreite;
	@Column(name = "größe")
	private String groesse;
	@Column(name = "status")
	private String status;
	@ManyToOne
	@JoinColumn(name = "gemeldetVon", referencedColumnName = "benutzername")
	private Benutzer gemeldetVon;
	@ManyToOne
	@JoinColumn(name = "berger", referencedColumnName = "benutzername")
	private Benutzer berger;

	public Netz(double gpsLänge, double gpsBreite, String groesse, String status) {
		this.gpsLänge = gpsLänge;
		this.gpsBreite = gpsBreite;
		this.groesse = groesse;
		this.status = status;
	}

	public Netz() {
	}

	public double getGpsLänge() {
		return gpsLänge;
	}

	public void setGpsLänge(double gpsLänge) {
		this.gpsLänge = gpsLänge;
	}

	public double getGpsBreite() {
		return gpsBreite;
	}

	public void setGpsBreite(double gpsBreite) {
		this.gpsBreite = gpsBreite;
	}

	public String getGroesse() {
		return groesse;
	}

	public void setGroesse(String groesse) {
		this.groesse = groesse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Benutzer getGemeldetVon() {
		return gemeldetVon;
	}

	public void setGemeldetVon(Benutzer gemeldetVon) {
		this.gemeldetVon = gemeldetVon;
	}

	public Benutzer getBerger() {
		return berger;
	}

	public void setBerger(Benutzer berger) {
		this.berger = berger;
	}

}
