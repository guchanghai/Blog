package com.chgu.data.model;

import java.io.Serializable;

public class Blogger implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5185756578987079424L;
	
	int id;
	String title;
	String category;
	String content;
	
	public Blogger() {
		super();
	}

	public Blogger(int id, String title, String category, String content) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.content = content;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
