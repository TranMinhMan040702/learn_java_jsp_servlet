package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;

public interface INewsDAO {
	List<NewsModel> findCategoryById(Long categoryid);
}
