package com.newlec.app.controller.notice;

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
import com.newlec.app.entity.NoticeView;
import com.newlec.app.service.NoticeService;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService service = new NoticeService();
		String id = request.getParameter("id");
		Notice notice = service.getNotice(id);
		NoticeView pNotice = service.getPrevNoticeView(id);
		System.out.println("pNotice 는 : " +pNotice);
		NoticeView nNotice = service.getNextNoticeView(id);
		System.out.println("nNotice 는 : " + nNotice);
		request.setAttribute("n", notice);
		request.setAttribute("nextV", nNotice);
		request.setAttribute("preV", pNotice);
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);

		 
	}
}
