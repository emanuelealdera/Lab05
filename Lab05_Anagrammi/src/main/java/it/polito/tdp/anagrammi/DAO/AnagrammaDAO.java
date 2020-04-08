package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	
	public AnagrammaDAO () {
	}
	
	public boolean isCorretto(String anagramma) {
		
		String sql = "Select nome from parola where nome=?"; 
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, anagramma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				conn.close();
				return true;
			}
			conn.close(); return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore nel caricamento del dizionario da DizionarioDAO");
		}
		
		return false;
	}

}
