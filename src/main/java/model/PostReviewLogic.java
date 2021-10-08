package model;

import dao.ReviewDAO;

public class PostReviewLogic {
	public void execute(Review review) {
		ReviewDAO dao = new ReviewDAO();
		dao.create(review);
	}
}
