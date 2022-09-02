package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.mapper.NewsMapper;
import com.laptrinhjavaweb.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findCategoryById(Long categoryid) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewsMapper(), categoryid);
	}

	@Override
	public Long save(NewsModel newsModel) {
		String sql = "insert into news (title, content, categoryid) values(?, ?, ?)";
		return insert (sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId());
	}

	@Override
	public void delete(NewsModel newsModel) {
		String sql = "delete from news where id = ?";
		update(sql, newsModel.getId());
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}
}
