package com.newlec.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlec.app.entity.Notice;
import com.newlec.app.entity.NoticeView;

public class NoticeService {
	
	public int removenoticeAll(int[] ids) {
		
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.cj.jdbc.Driver";
		String params = "";
		
		for(int i = 0 ; i < ids.length; i++) {
			if(i < ids.length-1) params += ids[i] + ",";
			else params += ids[i];
		}
			
		String sql = "delete from notice where id in("+ params +")";
		
		// 등차수열 : 1+(page-1)*10
		Connection con = null;
		Statement pst = null;
		int result = 0;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upwd);
			pst = con.createStatement();
			
			result = pst.executeUpdate(sql);
			
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public int pubNoticeAll(int[] ids) {
		return 0;
	}
	
	public int insertNotice(Notice notice) {
		return 0;
	}
	
	public int deletenotice(int id) {
		return 0;
	}
	
	public int updateNotice(int id) {
		return 0;
	}
	
	public List<Notice> getNoticeNewestList() {
		return null;
	}
	
	public List<NoticeView> getNoticeViewList() {
		return getNoticeViewList("title","", 1);
	}
	
	public List<NoticeView> getNoticeViewList(int page) {
		return getNoticeViewList("title","", page);
	}
	
	public List<NoticeView> getNoticeViewList(String field, String query, int page) {
		
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.cj.jdbc.Driver";
		String sql = "select * from (select (@rownum:=@rownum+1) as num, N.* from "
				+ "(select * from Notice_view order by RegDate desc ) N where (@rownum:=0)=0 ) NN "
				+ "where "+ field +" LIKE ? limit ? , 10";
		
		// 등차수열 : 1+(page-1)*10
		
		List<NoticeView> list = new ArrayList<NoticeView>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upwd);
			pst = con.prepareStatement(sql);
			
			pst.setString(1, "%"+query+"%");
			//pst.setInt(2, page);
			pst.setInt(2, (page-1)*10);	
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("Id");
				String title = rs.getString("Title");
				String writer = rs.getString("Writer_ID");
				Date date = rs.getDate("RegDate");
				int hit = rs.getInt("Hit");
				String files =  rs.getString("Files");
				//String content =  rs.getString("Content");
				int cmtcnt = rs.getInt("cmtcnt");
				
				NoticeView n = new NoticeView(id, title, writer, date, hit, files, cmtcnt);
				list.add(n);
			}	
			
		if( rs != null)	rs.close();
		if( pst != null) pst.close();
		if( con != null) con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int getNoticeViewCount() {
		return getNoticeViewCount("title","");
	}
	
	public int getNoticeViewCount(String field, String query) {
		
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.cj.jdbc.Driver";
		String sql = "select count(*) as count from ( select (@rownum:=@rownum+1) as num, N.* from "
				+ " (select * from notice order by RegDate desc ) N where (@rownum:=0)=0 ) NN "
				+ "where "+field+" LIKE ? ";
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
		} finally {
			
		}
		
		
		return count;
	}
	
	public NoticeView getNoticeView(int id) {
		
		NoticeView notice = null;
		
		String sql = "select * from notice where id = ?";
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.cj.jdbc.Driver";
		
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
				int cmtcnt =  rs.getInt("cmtcnt");	
				
				notice = new NoticeView(nid, title, writer, date, hit, files, cmtcnt);
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
	
	public NoticeView getNextNoticeView(int id) {
		
		String sql = "select * from (select (@rownum2:=@rownum2+1) as rownum2 , notice.* from notice where (@rownum2:=0)=0 ) NN where rownum2 > "
				+ " (select N.rownum from (select (@rownum:=@rownum+1) as rownum, notice.id from notice where (@rownum:=0)=0 ) N"
				+ " where id = ? ) order by rownum2 limit 1";
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.cj.jdbc.Driver";
		NoticeView notice = null;
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
				//String content =  rs.getString("Content");	
				int cmtcnt = rs.getInt("cmtcnt");
				
				notice = new NoticeView(nid, title, writer, date, hit, files, cmtcnt);
			
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
	
	public NoticeView getPrevNoticeView(int id) {
		
		String sql = "select * from (select (@rownum2:=@rownum2+1) as rownum2 , notice.*"
				+ " from notice where (@rownum2:=0)=0 ) NN where rownum2 < "
				+ "(select N.rownum from (select (@rownum:=@rownum+1) as rownum, notice.id"
				+ " from notice where (@rownum:=0)=0 ) N where id = ? ) order by rownum2 desc limit 1";
		
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		String uid = "root";
		String upwd ="root"; 
		String driver = "com.mysql.cj.jdbc.Driver";
		NoticeView notice = null;
		
		// 등차수열 : 1+(page-1)*10
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upwd);
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				int nid = rs.getInt("Id");
				String title = rs.getString("Title");
				String writer = rs.getString("Writer_ID");
				Date date = rs.getDate("RegDate");
				int hit = rs.getInt("Hit");
				String files =  rs.getString("Files");
				int cmtcnt =  rs.getInt("cmtcnt");	
				
				notice = new NoticeView(nid, title, writer, date, hit, files, cmtcnt);
			}
		
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(con != null) con.close();
		
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
