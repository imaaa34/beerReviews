package model;

import java.util.List;

import dao.ReviewDAO;

public class GetReviewListLogic {
	public List<Review> execute() {
		ReviewDAO dao = new ReviewDAO();
		List<Review> reviewList = dao.findAll();
		return reviewList;
	}
}
