package portfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;

//메일로 접수된 사항을 db로 저장하는 model
public class mail_insert {
	Connection con = null;
	PreparedStatement ps = null;
	m_dbinfo db = new m_dbinfo();
	String sql = "";
	int result;
	
	public int mail_in(String to_name, String to_mail, String subject, String context) {
		try {
			this.con = this.db.dbinfo();
			this.sql = "insert into hj_mail (midx,to_name,to_mail,subject,context,maildate)"
					+ "values ('0',?,?,?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, to_name);
			this.ps.setString(2, to_mail);
			this.ps.setString(3, subject);
			this.ps.setString(4, context);
			this.result = this.ps.executeUpdate();		
		}catch (Exception e) {	
			this.result = 0;
		}finally {
			try {
				this.ps.close();
				this.con.close();
			}catch (Exception e) {
				System.out.println("데이터베이스가 비정상적으로 접속해제되었습니다.");
			}
		}
		
		return result;
	}
}
