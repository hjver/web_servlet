package portfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class mail_select {
	Connection con = null;
	PreparedStatement ps = null;
	m_dbinfo db = new m_dbinfo();
	String sql = "";
	ResultSet rs = null;
	
	ArrayList<String> data = null; //한개의 데이터를 불러올 때
	ArrayList<ArrayList<String>> alldata = null;  //여러개의 데이터를 불러올 때
	
	public ArrayList<ArrayList<String>> maillist(){
		
		try {
			this.con = this.db.dbinfo();
			this.sql = "select midx,to_name,to_mail,subject,maildate,"
					+ "(select count(*) from hj_mail) as total"
					+ " from hj_mail order by midx desc limit 0,2";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			
			this.alldata = new ArrayList<ArrayList<String>>();
			
			/*
			String sql2 = "select count(*) as total from hj_mail";
			this.ps = this.con.prepareStatement(sql2);
			ResultSet rs2 = this.ps.executeQuery();
			rs2.next();
			*/
			
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("midx"));
				this.data.add(this.rs.getString("to_name"));
				this.data.add(this.rs.getString("to_mail"));
				this.data.add(this.rs.getString("subject"));
				this.data.add(this.rs.getString("maildate"));
				this.data.add(this.rs.getString("total"));
				//this.data.add(rs2.getString("total"));
				
				this.alldata.add(this.data);
			}
			//rs2.close();
		}catch (Exception e) {
			this.alldata = null;
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}catch (Exception e) {
				System.out.println("데이터베이스 오류발생!!");
			}
		}
		
		return this.alldata;
	}

}
