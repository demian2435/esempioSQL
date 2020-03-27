package it.polito.tdp.esempioSQL.model;

import java.util.List;

import it.polito.tdp.esempioSQL.db.BabsDAO;

public class LeggiBabs {

	public static void main(String[] args) {
		LeggiBabs babs = new LeggiBabs();
			babs.run();
	}

	private void run() {
		BabsDAO dao = new BabsDAO();
		
		List<Station> listaStazioni = dao.listStation();
		for (Station s : listaStazioni) {
			System.out.println(s);
		}
		
		System.out.println("----");
		
		List<Station> listaStazioniPaloAlto = dao.listStationByLandmark("Palo Alto");
		for (Station s : listaStazioniPaloAlto) {
			System.out.println(s);
		}
		
	}

}
