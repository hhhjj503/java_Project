package com.newlec.app.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.app.entity.Notice;
import com.newlec.app.service.NoticeService;

@WebServlet("/admin/board/notice/detail")
public class DetailController extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService service = new NoticeService();
		int id = Integer.parseInt(request.getParameter("id"));
		Notice notice = service.getNotice(id);
		request.setAttribute("n", notice);
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/detail.jsp").forward(request, response);

		 
	}
}
