package com.quiz.lesson01;

public class Post {
	// 필드
	private String title;
	private String user;
	private String content;
	
	// 기본 생성자
	public Post() {
		
	}
	
	// 메소드 생성사
	public Post(String title, String user, String content) {
		this.title = title;
		this.content = content;
		this.user = user;
	}
	
	// 메소드 getter, setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
