package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/beerReviews";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<User> showAll() {
		List<User> userList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT NAME, PASS FROM USER";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				User user = new User(name, pass);
				userList.add(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}
}
