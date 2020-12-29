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

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root";
		String sql = "select * from notice where id = ?";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, upwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			rs.next();
			
			//models
			String title = rs.getString("Title");
			String writer = rs.getString("Writer_ID");
			Date date = rs.getDate("RegDate");
			int hit = rs.getInt("Hit");
			String files =  rs.getString("Files");
			String content =  rs.getString("Content");
			
			Notice n = new Notice(id, title, writer, date, hit, files, content);
			
			rs.close();
			st.close();
			con.close();

			//redirect 완전히 새로운 서블렛을 다시 요청
			
			/*
			 * request.setAttribute("title", title); request.setAttribute("id", writer);
			 * request.setAttribute("date", date); request.setAttribute("hit", hit);
			 * request.setAttribute("files", files); request.setAttribute("content",
			 * content); -> 데이터들을 낱개로 보는것이 아니라 하나의 개체로 담으면 훨씬편하다
			 */ 
			
			request.setAttribute("n", n);
			
			//forward 작업한 내용들을 전송해줌
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
