package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {
	
	public void run() {
		
		// 1 - DEFINIRE L'URL DELLA CONNESSIONE
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		System.out.println("* URL creato");
		
		try {
			// 2 - STABILSCO LA ONNESSIONE
			Connection conn = DriverManager.getConnection(jdbcURL);
			System.out.println("* Connessione stabilita con il Database");
			
			// 3 - CREO UNO "STATEMENT OBJECT"
			Statement st = conn.createStatement();
			System.out.println("* Creato 'Statement Object'");
			String sql = "SELECT NAME FROM station";
			System.out.println("* Creata stringa contenente Query");
			
			// 4 - ESEGUI QUERY
			ResultSet rs = st.executeQuery(sql);
			System.out.println("* Eseguo la Query");
			
			// 5 - PROCESSA IL RISULTATO
			System.out.println("* Processo risultato INIZIO");
			while(rs.next()) {
				String nomeStazione = rs.getString("name");
				System.out.print(nomeStazione + ", ");
			}
			st.close();
			System.out.println("\n* Processo risultato FINE");

			// 6 - CHIUDI LA CONNESSIONE
			conn.close();
			System.out.println("* Connessione terminata");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LeggiBabs babs = new LeggiBabs();
		babs.run();
	}
}
