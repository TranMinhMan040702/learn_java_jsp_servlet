package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewsService newsService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel model = FormUtil.toModel(NewsModel.class, req);
		
		Integer offset = (model.getPage() - 1)*model.getMaxPageItem();
		model.setListResult(newsService.findAll(offset, model.getMaxPageItem()));
		model.setTotalItem(newsService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/news/list.jsp");
		rd.forward(req, resp);
	}
}
