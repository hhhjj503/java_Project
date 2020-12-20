package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		//jdbc:DB종류://hostName:port/DB이름
		String sql = "select * from Notice where hit > 10";
		
		//Class.forName("com.mysql.jdbc.Driver"); // mysql 의 jdbc driver 객체 정보를 가져옴
		Connection con = DriverManager.getConnection(url,"root","root");
		//jdbc 객체를 참조할수있는 변수가 Connection 형 변수 jdbc 드라이버를 가져오는 객체가 DriverManager
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
		int id = rs.getInt("Id");
		String title = rs.getString("Title");
		String writer_id = rs.getString("Writer_ID");
		String content = rs.getString("Content");
		Date regDate = rs.getDate("RegDate");
		int hit = rs.getInt("Hit");
		String files = rs.getString("Files");
		
		System.out.printf("id : %d\ntitle : %s\nwriter_id : %s\ncontent : %s\nregDate : %s\nhit : %d\nfiles : %s\n\n",
				id, title, writer_id, content, regDate, hit, files);
		}
		
		rs.close();
		st.close();
		con.close();
		
	}
}
