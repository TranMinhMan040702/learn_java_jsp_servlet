package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		try {
			NewsModel news = new NewsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setContent(resultSet.getString("content"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescrition(resultSet.getString("shortdescrition"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
