package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostReviewLogic;
import model.Review;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Reviewsをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<Review> reviewList = (List<Review>) application.getAttribute("reviewList");
		
//		取得できなかった場合は新規作成してアプリケーションスコープに保存
		if(reviewList == null) {
			reviewList = new ArrayList<>();
			application.setAttribute("reviewList", reviewList);
		}
		
//		ログインしているかセッションスコープからユーザー情報取得して確認
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			// ログインしていない場合indexにリダイレクト
			response.sendRedirect("/beerReviews/");
		} else {
	        // ログインしている場合Mainにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String beerName = request.getParameter("beerName");
		String area = request.getParameter("area");
		String text = request.getParameter("text");
		
		if(text != null && text.length() != 0) {
			// アプリケーションスコープに保存されたReviewListを取得
			ServletContext application = this.getServletContext();
			List<Review> reviewList = (List<Review>) application.getAttribute("reviewList");
			
			// セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			//  ReviewListに追加
			Review review = new Review(loginUser.getName(), beerName, area, text);
			PostReviewLogic postReviewLogic = new PostReviewLogic();
			postReviewLogic.execute(review, reviewList);
		} else {
			// エラーメッセージ追加
			request.setAttribute("errorMsg", "Form can't be empty.");
		}
		
		// メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}
}
