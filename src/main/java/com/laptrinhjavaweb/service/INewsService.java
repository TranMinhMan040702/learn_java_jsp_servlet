package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;

public interface INewsService {
	List<NewsModel> findCategoryById(Long categoryid);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel newsModel);
	void delete(long[] ids);
	List<NewsModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
}
