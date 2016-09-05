package com.ag.news.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ag.news.model.NewsInfo;

public class NewsDAOImpl implements NewsDAO {

	private SessionFactory sessionFactory;
	
	public NewsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public NewsInfo getNews(int id) {
		 Session session = sessionFactory.getCurrentSession();
		 NewsInfo newsInfo = (NewsInfo)session.get(NewsInfo.class, id);
		 return newsInfo;
	}
	
	@Transactional
	public List<NewsInfo> newsList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM NewsInfo");
		@SuppressWarnings("unchecked")
		List<NewsInfo> newsList = query.list();
		return newsList;
	}
	
	@Transactional
	public List<NewsInfo> filterList(String category) {
		if (!category.equals(null) && !category.isEmpty()) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM NewsInfo WHERE category="+"\'" + category + "\'");
			@SuppressWarnings("unchecked")
			List<NewsInfo> filterList = query.list();
			return filterList;
		}
		else
			return this.newsList();	
	}
	
	@Transactional
	public void createNews(NewsInfo news) {
		Session session = sessionFactory.getCurrentSession();
		session.save(news);	
	}
	
	@Transactional
	public void updateNews(NewsInfo news) {
		  Session session = sessionFactory.getCurrentSession();
	
		  NewsInfo newsInfo = (NewsInfo)session.get(NewsInfo.class, news.getId());
		  
		  newsInfo.setName(news.getName());
		  newsInfo.setDate(news.getDate());
		  newsInfo.setContent(news.getContent());
		  newsInfo.setCategory(news.getCategory());
		  
		  session.save(newsInfo);
	}
	
	@Transactional
	public void deleteNews(int id) {
		Session session = sessionFactory.getCurrentSession();
		NewsInfo newsInfo = (NewsInfo)session.get(NewsInfo.class, id);
		session.delete(newsInfo);	
	}

}
