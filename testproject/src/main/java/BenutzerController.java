import java.io.Serializable;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class BenutzerController implements Serializable {
	private static final long serialVersionUID = 1244393533452613418L;

	@Inject
	Benutzerliste benutzerliste;

	private String name;
	private String telefon;
	private boolean berger;
	private Benutzer aktuellerBenutzer = new Benutzer("", "", "", true);
	private boolean logedIn = false;
	private Benutzer admin = new Benutzer("admin", "admin", "0000", true);

	public Benutzer getAktuellerBenutzer() {
		return aktuellerBenutzer;
	}

	public void setAktuellerBenutzer(Benutzer aktuellerBenutzer) {
		this.aktuellerBenutzer = aktuellerBenutzer;
	}

	public boolean isLogedIn() {
		return logedIn;
	}

	public void postValidateName(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput) ev.getComponent();
		this.name = (String) temp.getValue();
	}

	public void postValidateTelefon(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput) ev.getComponent();
		this.telefon = (String) temp.getValue();
	}

	public void postValidateBerger(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput) ev.getComponent();
		this.berger = (Boolean) temp.getValue();
	}

	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		aktuellerBenutzer.setName(this.name);
		aktuellerBenutzer.setTelefonnummer(this.telefon);
		aktuellerBenutzer.setIsBerger(this.berger);
		aktuellerBenutzer.setPasswort((String) value);
		for (Benutzer c : benutzerliste.getAlleBenutzer()) {
			if (c.equals(aktuellerBenutzer)) // falls Benutzer vorhanden, einloggen
			{
				logedIn = true;
				benutzerliste.benutzerDao.saveBenutzer(aktuellerBenutzer); // update Telefonnummer/Berechtigung zum
																			// Bergen
			}
		}
		if (logedIn == false) {
			boolean benutzerVorhanden = false;
			for (Benutzer c : benutzerliste.getAlleBenutzer()) {
				if (c.getName().equals(aktuellerBenutzer.getName())) // Benutzername in Datenbank vorhanden, aber
																		// Passwort falsch
				{
					benutzerVorhanden = true;
					throw new ValidatorException(new FacesMessage(
							"Benutzer bereits vorhanden. Das Passwort ist falsch. Bitte korriegiren Sie das Passwort oder wählen Sie einen anderen Nutzernamen"));
				}
			}
			if (benutzerVorhanden == false) {
				benutzerliste.benutzerDao.createBenutzer(aktuellerBenutzer);
				logedIn = true;
			} // Benutzer wird neu angelegt
		}
	}

	public void login() {
		benutzerliste.benutzerDao.saveBenutzer(admin); // admin Zugang anlegen, falls Datenbank leer ist

	}

	public void logout() {
		logedIn = false;
		aktuellerBenutzer = new Benutzer();

	}
}