package model;

import java.util.List;

public class PostReviewLogic {
	public void execute(Review review, List<Review> reviewList) {
		reviewList.add(0, review);  //先頭に追加していく
	}
	
	public void addToMypage(Review review, List<Review> myreviewList) {
		myreviewList.add(0, review);
	}
}
