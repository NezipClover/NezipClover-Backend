package com.ssafy.Whereismyhouse.qna.model.dto;

import java.io.Serializable;

public class Question implements Serializable{
	private int id;
	private String title;
	private String content;
	private String author;

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
