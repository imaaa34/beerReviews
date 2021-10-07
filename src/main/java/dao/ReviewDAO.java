package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;

public class ReviewDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/beerReviews";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Review> showAll() {
		List<Review> beerList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT USERNAME, BEERNAME, AREA, TEXT FROM REVIEW";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String userName = rs.getString("USERNAME");
				String beerName = rs.getString("BEERNAME");
				String area = rs.getString("AREA");
				String text = rs.getString("TEXT");
				Review review = new Review(userName, beerName, area, text);
				beerList.add(review);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return beerList;
	}
}