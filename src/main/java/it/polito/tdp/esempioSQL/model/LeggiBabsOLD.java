package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeggiBabsOLD {

	public void run() {

		// 1 - DEFINIRE L'URL DELLA CONNESSIONE
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		System.out.println("* URL creato");

		try {
			// 2 - STABILSCO LA ONNESSIONE
			Connection conn = DriverManager.getConnection(jdbcURL);
			System.out.println("* Connessione stabilita con il Database");

			// 3 - CREO UNO "STATEMENT OBJECT"
			String sql = "SELECT NAME FROM station WHERE landmark = ?";
			System.out.println("* Creata stringa contenente Query");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "Palo Alto");
			System.out.println("* Preparo lo 'Statement Object'");

			// 4 - ESEGUO LA QUERY
			ResultSet rs = st.executeQuery();
			System.out.println("* Eseguo la Query");

			// 5 - PROCESSO IL RISULTATO
			System.out.println("* Processo risultato INIZIO");
			while (rs.next()) {
				String nomeStazione = rs.getString("name");
				if (rs.isLast()) {
					System.out.println(nomeStazione);
				} else {
					System.out.print(nomeStazione + ", ");
				}
			}
			st.close();
			System.out.println("* Processo risultato FINE");

			// 6 - CHIUDO LA CONNESSIONE
			conn.close();
			System.out.println("* Connessione terminata");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LeggiBabsOLD babs = new LeggiBabsOLD();
		babs.run();
	}
}
