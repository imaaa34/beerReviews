package model;

import java.io.Serializable; //直列化

//名前とパスワードを持つJavaBeansクラス
public class User implements Serializable {
	private String name;
	private String email;
	private String pass;
	
	public User() {}
	public User(String name, String email,String pass) {
		this.name = name;
		this.email = email;
		this.pass = pass;
	}
	
	public String getName() { return name; }
	public String getEmail() { return email; }
	public String getPass() { return pass; }
}
