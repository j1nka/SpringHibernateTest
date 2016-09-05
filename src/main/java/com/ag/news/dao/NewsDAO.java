package com.ag.news.dao;

import java.util.List;

import com.ag.news.model.NewsInfo;

public interface NewsDAO {
	
	public List<NewsInfo> newsList();
	public List<NewsInfo> filterList(String category);
	public void createNews(NewsInfo news);
	public void updateNews(NewsInfo news);
	public void deleteNews(int id);
	public NewsInfo getNews(int id);
	
}
