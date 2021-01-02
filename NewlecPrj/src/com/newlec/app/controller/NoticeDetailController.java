package com.newlec.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.app.entity.Notice;
import com.newlec.app.service.NoticeService;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService service = new NoticeService();
		service.getNotice(id);
		
		
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);

		 
	}
}
