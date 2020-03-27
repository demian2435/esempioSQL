package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import it.polito.tdp.esempioSQL.model.Station;

public class BabsDAO {
	
	public List<Station> listStation() {
		List<Station> resultList = new ArrayList<>();
		String sql = "SELECT station_id, name, dockcount, landmark FROM station ORDER BY station_id";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Station s = new Station(rs.getInt("station_id"), rs.getString("name"), rs.getInt("dockcount"),
						rs.getString("landmark"));
				resultList.add(s);
			}
			st.close();
			conn.close();
			return resultList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Station> listStationByLandmark(String landmark) {
		List<Station> resultList = new ArrayList<>();
		String sql = "SELECT station_id, name, dockcount, landmark FROM station WHERE landmark=? ORDER BY station_id";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, landmark);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Station s = new Station(rs.getInt("station_id"), rs.getString("name"), rs.getInt("dockcount"),
						rs.getString("landmark"));
				resultList.add(s);
			}
			st.close();
			conn.close();
			return resultList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
