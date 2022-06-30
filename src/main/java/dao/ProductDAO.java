package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ProductDTO;

public class ProductDAO {

	private ResultSet rs; 
	private static PreparedStatement psmt;
	private static Connection conn;

	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String db_id = "c##qqq";
			String db_pw = "123";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


	public List<ProductDTO> listproduct() {
		
		  List<ProductDTO> list = new ArrayList<ProductDTO>();
	        try {
	        	getConnection();
	             String query = "select * from products ";
	             System.out.println("PrepareStatement: " + query);
	             psmt = conn.prepareStatement(query);
	             ResultSet rs = psmt.executeQuery();
	             
	            while (rs.next()) {
	                String product_id = rs.getString("product_id");
	                String product_name = rs.getString("product_name");
	                String description = rs.getString("description");
	                String standard_cost = rs.getString("standard_cost");
	                String list_price = rs.getString("list_price");

	                ProductDTO vo = new ProductDTO();
	                vo.setId(product_id);
	                vo.setName(product_name);
	                vo.setDes(description);
	                vo.setCost(standard_cost);
	                vo.setPrice(list_price); 
	                list.add(vo); 
	            }
	        } catch (SQLException e) { 
				e.printStackTrace();
			} finally {
				close();
			}
	         
	        return list; 
	    }
	
	public List slistproduct(ProductDTO productVO) {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
        String name_1 = productVO.getName();
        try {
            getConnection();
            String query = "select * from products";
            
            if((name_1 != null && name_1.length() != 0)) {
                query += " where product_name like '%' || ? || '%'";
                psmt = conn.prepareStatement(query);
                psmt.setString(1, name_1);
            }else {
                psmt = conn.prepareStatement(query);
            }
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                String product_id = rs.getString("product_id");
                String product_name = rs.getString("product_name");
                String description = rs.getString("description");
                String standard_cost = rs.getString("standard_cost");
                String list_price = rs.getString("list_price");
                
                ProductDTO vo = new ProductDTO();
                vo.setId(product_id);
                vo.setName(product_name);
                vo.setDes(description);
                vo.setCost(standard_cost);
                vo.setPrice(list_price); 
                list.add(vo); 
            }
        } catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			close();
		}
         
        return list; 
	}
	}