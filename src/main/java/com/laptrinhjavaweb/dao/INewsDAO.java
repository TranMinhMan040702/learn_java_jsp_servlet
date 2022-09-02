package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;

public interface INewsDAO extends GenericDAO<NewsModel> {
	NewsModel findOne(Long id);
	List<NewsModel> findCategoryById(Long categoryid);
	Long save(NewsModel newsModel);
	void delete(NewsModel newsModel);
}
