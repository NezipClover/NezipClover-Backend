package com.ssafy.Whereismyhouse.qna.model.dto;

import java.io.Serializable;

public class QuestionRegister implements Serializable{
	private String title;
	private String content;
	private String author;
	public QuestionRegister(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
