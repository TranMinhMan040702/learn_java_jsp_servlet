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
		StringBuilder sql = new StringBuilder("insert into news (title, thumbnail, shortdescrition,  ");
		sql.append(" content, categoryid, createddate, createdby) ");
		sql.append("values(?, ?, ?, ?, ?, ?, ?)");
		return insert (sql.toString(), newsModel.getTitle(), newsModel.getThumbnail(), newsModel.getShortDescrition(), 
				newsModel.getContent(), newsModel.getCategoryId(), newsModel.getCreatedDate(), newsModel.getCreatedBy());
		
	}

	@Override
	public void delete(long id) {
		String sql = "delete from news where id = ?";
		update(sql, id);
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNews) {
		StringBuilder sql = new StringBuilder("update news set title = ?, thumbnail = ?, ");
		sql.append("shortdescrition = ?, content = ?, categoryid = ?, ");
		sql.append("createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? where id = ?");
		update(sql.toString(), updateNews.getTitle(), updateNews.getThumbnail(), updateNews.getShortDescrition(),
				updateNews.getContent(), updateNews.getCategoryId(), 
				updateNews.getCreatedDate(), updateNews.getCreatedBy(), 
				updateNews.getModifiedDate(), updateNews.getModifiedBy(), updateNews.getId());	
	}

	@Override
	public List<NewsModel> findAll(Integer offset, Integer limit) {
		String sql = "select * from news limit ?, ?";
		return query(sql, new NewsMapper(), offset, limit);
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from news";
		return count(sql);
	}
}
