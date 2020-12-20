package ex1;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.PreparedStatement;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String title = "test2";
		String writer_id= "newlec";
		String content= "ccc";
		String files = "";
		
		String url = "jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Seoul&useSSL=false";
		//jdbc:DB종류://hostName:port/DB이름
		String sql = "insert into notice(title,writer_id,content,files) values(?,?,?,?)";
		
		
		//Class.forName("com.mysql.jdbc.Driver"); // mysql 의 jdbc driver 객체 정보를 가져옴
		Connection con = DriverManager.getConnection(url,"root","root");
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
		
	}
}
