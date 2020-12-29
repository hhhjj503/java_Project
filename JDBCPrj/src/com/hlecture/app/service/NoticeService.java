package com.hlecture.app.service;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hlecture.app.sentity.Notice;

public class NoticeService {
	
	private String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
	private String uid = "root";
	private String upwd = "root";
	private String driver ="com.mysql.jdbc.Driver";
	
	public int getCount() throws SQLException {
		int count = 0;
		String sql = "select count(Id) as count from Notice";
		
		Connection con = DriverManager.getConnection(url, uid, upwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) 
		count = Integer.parseInt(rs.getString("count"));
		
		rs.close();
		st.close();
		con.close();
		
		return count;
	}
	
	public List<Notice> getList(int page, String searchOption ,String searchQuery) throws SQLException {
		
		//jdbc:DB종류://hostName:port/DB이름
		String sql = "select * from Notice where ? like ? order by Id desc limit ?,?";
		int start = (page -1) * 10;
		int end = 10 * page;
		int count = 10;
		
		//Class.forName("com.mysql.jdbc.Driver"); // mysql 의 jdbc driver 객체 정보를 가져옴
		Connection con = DriverManager.getConnection(url,uid, upwd);
		//jdbc 객체를 참조할수있는 변수가 Connection 형 변수 jdbc 드라이버를 가져오는 객체가 DriverManager
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, searchOption);
		st.setString(2, "%"+searchQuery+"%");
		st.setInt(3, start);
		st.setInt(4, count);
		ResultSet rs = st.executeQuery();
		List<Notice> list = new ArrayList<Notice>(); //리스트
		//int[] inti = new int[3]; : 배열
		
		while(rs.next()) {
		int id = rs.getInt("Id");
		String title = rs.getString("Title");
		String writer_id = rs.getString("Writer_ID");
		String content = rs.getString("Content");
		Date regDate = rs.getDate("RegDate");
		int hit = rs.getInt("Hit");
		String files = rs.getString("Files");
		
		Notice notice = new Notice(id,title,writer_id,content,regDate,hit,files);
		list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public int insert(Notice notice) throws SQLException {
			
			String title = notice.getTitle();
			String writer_id= notice.getWriter_id();
			String content= notice.getContent();
			String files = notice.getFiles();
			
			//jdbc:DB종류://hostName:port/DB이름
			String sql = "insert into notice(title,writer_id,content,files) values(?,?,?,?)";
			
			//Class.forName("com.mysql.jdbc.Driver"); // mysql 의 jdbc driver 객체 정보를 가져옴
			Connection con = DriverManager.getConnection(url,uid, upwd);
			//jdbc 객체를 참조할수있는 변수가 Connection 형 변수 jdbc 드라이버를 가져오는 객체가 DriverManager
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, writer_id);
			st.setString(3, content);
			st.setString(4, files);
			int result = st.executeUpdate();
			System.out.println(result);
			//Statement st = con.createStatement();
			//st.executeQuery(sql); ->preparedstatement 는 여기에 ? 로 파라미터를 넣을 수 있다
			st.close();
			con.close();
			
		return result;
	}
	
	public int update(Notice notice) throws SQLException {
		
		String title = notice.getTitle();
		String writer_id= notice.getWriter_id();
		String content= notice.getContent();
		String files = notice.getFiles();
		
		String sql = "delete from notice where id = ?";
		
		Connection con = DriverManager.getConnection(url,uid, upwd);
		PreparedStatement st = con.prepareStatement(sql);
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		con.close();

		return 0;
	}

	public int delete(int id) throws SQLException {
		
		String title = "test2";
		String writer_id= "newlec";
		String content= "ddd";
		String files = "";		
		String sql = "update notice set title = ?, content = ? ,files = ? where id = ?";
		
		//Class.forName("com.mysql.jdbc.Driver"); // mysql 의 jdbc driver 객체 정보를 가져옴
		Connection con = DriverManager.getConnection(url,uid, upwd);
		//jdbc 객체를 참조할수있는 변수가 Connection 형 변수 jdbc 드라이버를 가져오는 객체가 DriverManager
		//Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writer_id);
		st.setString(3, content);
		st.setInt(4, id);
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		con.close();

		return result;
	}

	
}
