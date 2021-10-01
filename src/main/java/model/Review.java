package model;

import java.io.Serializable;

//投稿者名と本文を持つJavaBeansクラス
public class Review implements Serializable {
	private String userName;
	private String text;
	
	public Review() {}
	public Review(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	
	public String getUserName() { return userName; }
	public String getText() { return text; }
}
