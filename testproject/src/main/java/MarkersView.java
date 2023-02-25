import java.io.Serializable;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Symbol;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MarkersView implements Serializable {

	private MapModel<Long> simpleModel;

	@Inject
	Netzliste netzliste;

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel<>();

		for (Netz n : netzliste.getAlleNetze()) {
			simpleModel.addOverlay(
					new Marker<>(new LatLng(n.getGpsBreite(), n.getGpsLänge()), "" + n.getId(), 2L, createSymbol(n)));
		}
	}

	public MapModel<Long> getSimpleModel() {
		return simpleModel;
	}

	public Symbol createSymbol(Netz n) {
		Symbol symbol = new Symbol(
				"M10.453 14.016l6.563-6.609-1.406-1.406-5.156 5.203-2.063-2.109-1.406 1.406zM12 2.016q2.906 0 4.945"
						+ " 2.039t2.039 4.945q0 1.453-0.727 3.328t-1.758 3.516-2.039 3.070-1.711 2.273l-0.75"
						+ " 0.797q-0.281-0.328-0.75-0.867t-1.688-2.156-2.133-3.141-1.664-3.445-0.75-3.375q0-2.906"
						+ " 2.039-4.945t4.945-2.039z");
		symbol.setFillOpacity(.7);
		if (n.getStatus().equals("Gemeldet")) {
			symbol.setFillColor("#ed0808");
		}
		if (n.getStatus().equals("Bergung bevorstehend")) {
			symbol.setFillColor("#0f85f2");
		}
		if (n.getStatus().equals("Geborgen")) {
			symbol.setFillColor("#54ed11");
		}
		if (n.getStatus().equals("Verschollen")) {
			symbol.setFillColor("#ef7d07");
		}
		return symbol;

	}

}
