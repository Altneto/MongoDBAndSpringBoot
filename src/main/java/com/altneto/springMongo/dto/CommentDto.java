package com.altneto.springMongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String text;
	private LocalDate date;
	private AuthorDto author;
	
	public CommentDto() {
		super();
	}
	
	public CommentDto(String text, LocalDate date, AuthorDto author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
	}
}
