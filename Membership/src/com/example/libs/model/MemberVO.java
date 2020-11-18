package com.example.libs.model;

public class MemberVO {
	private String userid;
	private String passwd;
	private String name;
	private String email;
	private String gender;
	private String city;
	private int age;
	
	public MemberVO() {    // 기본 생성자(다 비워서),  for Java Bean 용
		this.city = "";
	}
	
	

	public MemberVO(String userid, String passwd, String name, String email, String gender) {  // 필요한 생성자들 (Not null만 처리)
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.gender = gender;
	}



	public MemberVO(String userid, String passwd, String name, String email, String gender, String city, int age) {  // 모두 처리
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.city = city;
		this.age = age;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
