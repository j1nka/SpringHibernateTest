package com.ag.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ag.news.dao.NewsDAO;
import com.ag.news.model.NewsInfo;

@Controller
public class MainController {

	
	@Autowired //auto-binding through dependency in â servlet-context
    private NewsDAO newsDao;
     
	@RequestMapping(value="")
	public String defaultPage() {
		return "redirect:/show";
	}
	
	@RequestMapping(value="/show", method = RequestMethod.GET)
    public String getFilterPage(Model model) {
		model.addAttribute("filterNews", new NewsInfo());
		List<NewsInfo> newsList = newsDao.newsList();
	    model.addAttribute("newsList",newsList);
        return "homepage";
    }
	
	@RequestMapping(value="/show", method = RequestMethod.POST)
    public String filterPage(@ModelAttribute("filterNews") NewsInfo filterNews, Model model, BindingResult result) {
        List<NewsInfo> filterList = newsDao.filterList(filterNews.getCategory());
		model.addAttribute("newsList", filterList);
        return "homepage";
    }
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String getAddPage(Model model) {
        model.addAttribute("newNews", new NewsInfo());
        return "addpage";
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addPage(@ModelAttribute("newNews") NewsInfo newNews, BindingResult result) {
        newsDao.createNews(newNews);
        return "redirect:/show";
    }
    
    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String editPage(Model model, @RequestParam(value="id", required = true) int id) {
        model.addAttribute("newsToEdit", newsDao.getNews(id));
        return "editpage";
    }
    
    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String getEditPage(@ModelAttribute("newsToEdit") NewsInfo newsToEdit, BindingResult result) {
        
    	newsDao.updateNews(newsToEdit);
        return "redirect:/show";
    }
    
    @RequestMapping(value ="/delete")
    public String deleteNews(@RequestParam(value="id", required = true) int id) {
    	
    	newsDao.deleteNews(id);
    	return "redirect:/show";
    }
    
}
