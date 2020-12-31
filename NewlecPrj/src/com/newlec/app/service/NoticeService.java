package com.newlec.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.newlec.app.entity.Notice;

public class NoticeService {
	
	public List<Notice> getNoticeList() {
		return getNoticeList("title","", 1);
	}
	
	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title","", page);
	}
	
	public List<Notice> getNoticeList(String field, String query, int page) {
		
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.jdbc.Driver";
		String sql = "select * from ( select (@rownum:=@rownum+1) as num, N.* from "
				+ " (select * from notice order by RegDate desc ) N where (@rownum:=0)=0 ) NN "
				+ "where "+field+" like ? and num between ? and ? ";
		
		// 등차수열 : 1+(page-1)*10
		
		
		List<Notice> list = new ArrayList<Notice>();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, upwd);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+query+"%");
			st.setInt(2, page);
			st.setInt(3, 1+(page-1)+10);
			
			ResultSet rs = st.executeQuery();
			
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
		
		
		return list;
	}
	
	public int getNoticeCount() {
		return getNoticeCount("title","");
	}
	
	public int getNoticeCount(String field, String query) {
		
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.jdbc.Driver";
		String sql = "select count(*) as count from ( select (@rownum:=@rownum+1) as num, N.* from "
				+ " (select * from notice order by RegDate desc ) N where (@rownum:=0)=0 ) NN "
				+ "where "+field+" like ? ";
		int count = 0;
		
		// 등차수열 : 1+(page-1)*10
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, upwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			count = rs.getInt("count");
			
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
		
		
		return count;
	}
	
	public Notice getNotice(int id) {
		
		Notice notice = null;
		
		String sql = "select * from notice where id = ?";
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, upwd);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int nid = rs.getInt("Id");
				String title = rs.getString("Title");
				String writer = rs.getString("Writer_ID");
				Date date = rs.getDate("RegDate");
				int hit = rs.getInt("Hit");
				String files =  rs.getString("Files");
				String content =  rs.getString("Content");	
				
				notice = new Notice(nid, title, writer, date, hit, files, content);
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
		
		return notice;
	}
	
	public Notice getNextNotice(int id) {
		
		String sql = "select * from (select (@rownum2:=@rownum2+1) as rownum2 , notice.* from notice where (@rownum2:=0)=0 ) NN where rownum2 > "
				+ " (select N.rownum from (select (@rownum:=@rownum+1) as rownum, notice.id from notice where (@rownum:=0)=0 ) N"
				+ " where id = ? ) order by rownum2 limit 1";
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.jdbc.Driver";
		Notice notice = null;
		
		// 등차수열 : 1+(page-1)*10
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, upwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int nid = rs.getInt("Id");
				String title = rs.getString("Title");
				String writer = rs.getString("Writer_ID");
				Date date = rs.getDate("RegDate");
				int hit = rs.getInt("Hit");
				String files =  rs.getString("Files");
				String content =  rs.getString("Content");	
				
				notice = new Notice(nid, title, writer, date, hit, files, content);
			
				rs.close();
				st.close();
				con.close();
			}
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
	
	public Notice getPrevNotice(int id) {
		
		String sql = "select * from (select (@rownum2:=@rownum2+1) as rownum2 , notice.*"
				+ " from notice where (@rownum2:=0)=0 ) NN where rownum2 < "
				+ "(select N.rownum from (select (@rownum:=@rownum+1) as rownum, notice.id"
				+ " from notice where (@rownum:=0)=0 ) N where id = ? ) order by rownum2 desc limit 1";
		
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.jdbc.Driver";
		Notice notice = null;
		
		// 등차수열 : 1+(page-1)*10
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, upwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int nid = rs.getInt("Id");
				String title = rs.getString("Title");
				String writer = rs.getString("Writer_ID");
				Date date = rs.getDate("RegDate");
				int hit = rs.getInt("Hit");
				String files =  rs.getString("Files");
				String content =  rs.getString("Content");	
				
				notice = new Notice(nid, title, writer, date, hit, files, content);
			
				rs.close();
				st.close();
				con.close();
			}
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;

	}
}
