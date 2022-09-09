package com.laptrinhjavaweb.controller.web;



import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ResourceBundle bundle = ResourceBundle.getBundle("message");
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = req.getParameter("message");
			String altert = req.getParameter("altert");
			if (message != null && altert != null) {
				req.setAttribute("message", bundle.getString(message));
				req.setAttribute("altert", altert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/trang-chu");
		} else {
			req.setAttribute("categories", categoryService.findAll());
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);		
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if (model != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", model);
				if (model.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu");
				} else if (model.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				} else {
					resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&altert=danger");
			}
		}
	}
}
