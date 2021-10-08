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
	
	public List<Review> findAll() {
		List<Review> reviewList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT ID, USERNAME, BEERNAME, AREA, TEXT FROM REVIEW ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("USERNAME");
				String beerName = rs.getString("BEERNAME");
				String area = rs.getString("AREA");
				String text = rs.getString("TEXT");
				Review review = new Review(id, userName, beerName, area, text);
				reviewList.add(review);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return reviewList;
	}
	
	public boolean create(Review review) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO REVIEW(USERNAME, BEERNAME, AREA, TEXT) VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, review.getUserName());
			pStmt.setString(2, review.getBeerName());
			pStmt.setString(3, review.getArea());
			pStmt.setString(4, review.getText());
			
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}