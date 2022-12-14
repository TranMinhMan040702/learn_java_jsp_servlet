package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewsService {
	List<NewsModel> findCategoryById(Long categoryid);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel newsModel);
	void delete(long[] ids);
	List<NewsModel> findAll(Pageble pageble);
	NewsModel findOne(Long id);
	int getTotalItem();
}
