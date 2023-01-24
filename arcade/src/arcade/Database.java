package arcade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Database {
	
	int score;
	String name;
	public Database(){
		score =0;
		name="";
		
	}
	
	public void playerName(String n) {
		String sql ="INSERT INTO ArcadeTable Name Values ?";
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, n);
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	public void playerScore(int n) {
		
	}
	private Connection connect() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:D:/SQLiteStudio/ArcadeDataBase.db";
			conn = DriverManager.getConnection(url);
			//System.out.println("Connection has been made");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
		
}
