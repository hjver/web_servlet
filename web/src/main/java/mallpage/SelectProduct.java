package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DBConnect;

public class SelectProduct {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    private DBConnect db = new DBConnect(); 
    private ArrayList<ProductDto> products = new ArrayList<>(); // ArrayList 초기화
    private ProductDto product = null;

    public ArrayList<ProductDto> selectProducts() {
    	
        try {
            this.con = this.db.getConnection();  // DB 연결
            this.sql = "SELECT midx, pnm, pmoney, psales, psmoney, pimg FROM mall_product";
            this.ps = this.con.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {
                this.product = new ProductDto(); // 새 DTO 객체 생성
                product.setMidx(this.rs.getInt("midx"));  
                product.setPnm(this.rs.getString("pnm"));
                product.setPmoney(this.rs.getInt("pmoney"));  
                product.setPsales(this.rs.getInt("psales"));  
                product.setPsmoney(this.rs.getInt("psmoney"));
                product.setPimg(this.rs.getString("pimg"));
                
                this.products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();  // 예외 메시지 출력
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.ps != null) this.ps.close();
                if (this.con != null) this.con.close();
            } catch (Exception e) {
                e.printStackTrace(); // 자원 해제 실패 시 출력
            }
        }
        
        return products;
    }
    
    public ProductDto selectOne(int midx) {
    	
    	this.product = new ProductDto(); // 새 DTO 객체 생성
    	
        try {
            this.con = this.db.getConnection();  // DB 연결
            this.sql = "SELECT midx, pnm, pmoney, psales, psmoney, pimg FROM mall_product where midx=?";
            this.ps = this.con.prepareStatement(this.sql);
            this.ps.setInt(1, midx);
            this.rs = this.ps.executeQuery();

            if (this.rs.next()) {
                product.setMidx(this.rs.getInt("midx"));  
                product.setPnm(this.rs.getString("pnm"));
                product.setPmoney(this.rs.getInt("pmoney"));  
                product.setPsales(this.rs.getInt("psales"));  
                product.setPsmoney(this.rs.getInt("psmoney"));
                product.setPimg(this.rs.getString("pimg"));
            }

        } catch (Exception e) {
            e.printStackTrace();  // 예외 메시지 출력
            
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.ps != null) this.ps.close();
                if (this.con != null) this.con.close();
            } catch (Exception e) {
                e.printStackTrace(); // 자원 해제 실패 시 출력
            }
        }
        
        return this.product;  	
    }
}