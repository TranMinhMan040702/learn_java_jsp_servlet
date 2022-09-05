package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewsService;

public class NewsService implements INewsService{

	@Inject
	private INewsDAO newsDao;
	@Override
	public List<NewsModel> findCategoryById(Long categoryid) {
		return newsDao.findCategoryById(categoryid);
	}
	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreatedBy("");
		Long newsId = newsDao.save(newsModel);
		return newsDao.findOne(newsId);
	}
	
	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDao.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNews.setModifiedBy("");
		newsDao.update(updateNews);
		return newsDao.findOne(updateNews.getId());
	}
	
	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newsDao.delete(id);
		}
		
	}
	
	@Override
	public List<NewsModel> findAll(Integer offset, Integer limit) {
		return newsDao.findAll(offset, limit);
	}
	@Override
	public int getTotalItem() {
		return newsDao.getTotalItem();
	}
}
