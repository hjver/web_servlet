package portfolio;
//데이터베이스를 사용하기 위해서는 해당 프로젝트에서 DB버전에 맞는 라이브러리를 설정해야 함

//Connection은 java.sql.
import java.sql.Connection;
import java.sql.DriverManager;

public class m_dbinfo {
	public static Connection dbinfo() {
		String db = "com.mysql.cj.jdbc.Driver";  //데이터베이스 사용 라이브러리 명 : 5.1 드라이버
		String db_url = "jdbc:mysql://localhost:3306/mrp"; //데이터베이스 접속경로
		String db_user = "project"; //db 접속 아이디
		String db_pass = "a123456";  //db 접속 패스워드
		Connection con = null;
		
		try {
			Class.forName(db); //라이브러리 사용
			con = DriverManager.getConnection(db_url,db_user,db_pass);
		}
		catch (Exception e) {
			System.out.println("DB 연결 실패!!");
		}
		return con;
	}
}
