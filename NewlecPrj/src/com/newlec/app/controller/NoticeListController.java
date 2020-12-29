package com.newlec.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.app.entity.Notice;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String sql = "select * from notice";
		String driver = "com.mysql.jdbc.Driver";
		List<Notice> list = new ArrayList<Notice>();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, upwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("Id");
				String title = rs.getString("Title");
				String writer = rs.getString("Writer_ID");
				Date date = rs.getDate("RegDate");
				int hit = rs.getInt("Hit");
				String files =  rs.getString("Files");
				String content =  rs.getString("Content");	
				
				Notice n = new Notice(id, title, writer, date, hit, files, content);
				list.add(n);
			}	
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/notice/newfile.jsp").forward(request, response);
		
	}
}
