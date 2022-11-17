package com.ssafy.Whereismyhouse.qna.model.dto;

import java.io.Serializable;

public class AnswerRegister implements Serializable{

	private String title;
	private String content;
	private String author;
	private int questionId;
	public AnswerRegister(String title, String content, String author, int questionId) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.questionId = questionId;
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
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	@Override
	public String toString() {
		return "AnswerRegister [title=" + title + ", content=" + content + ", author=" + author + ", questionId="
				+ questionId + "]";
	}
	
}
