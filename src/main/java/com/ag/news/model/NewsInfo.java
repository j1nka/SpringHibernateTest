package com.ag.news.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;

//POJO (plain old java object creation and binding with a DB (in my case
//it was MySQL DB "News" with one single table in it - "NEWSOFTHEWORLD")

@Entity
@Table(name = "NEWSOFTHEWORLD")
public class NewsInfo {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="DATE")
	private String date;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Transient //For correlation with MySQL date-format (this won't create new column 
	//because of transient)
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public NewsInfo() {
		this.name = "Type news info";
		this.content = "Type content";
		this.date = dateFormat.format(new Date());
		this.category = "Type category";
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public NewsInfo getNews(int id) {
		if (this.id == id) return this;
		return null;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setDate(String date) {
		try {
			dateFormat.parse(date);
			this.date = date;
		}
		catch (ParseException e)
		{
			this.date = dateFormat.format(new Date());
		}
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
	
}
