package model;

import java.io.Serializable;

//投稿者名と本文を持つJavaBeansクラス
public class Review implements Serializable {
	private String userName;
	private String beerName;
	private String area;
	private String text;
	
	public Review() {}
	public Review(String userName, String beerName, String area, String text) {
		this.userName = userName;
		this.beerName = beerName;
		this.area = area;
		this.text = text;
	}
	
	public String getUserName() { return userName; }
	public String getBeerName() { return beerName; }
	public String getArea() { return area; }
	public String getText() { return text; }
}
