package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CityDTO;
import dto.CustomerDTO;
import dto.ProductDTO;

public class CityDAO {

	private ResultSet rs; 
	private PreparedStatement psmt;
	private Connection conn;

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

	public List<CityDTO> listcity() {
		
		  List<CityDTO> list = new ArrayList<CityDTO>();
	        try {
	        	getConnection();
	             String query = "select x.warehouse_name, y.product_name, z.quantity "
	             		+ "from warehouses x, products y, inventories z "
	             		+ "where x.warehouse_id=z.warehouse_id and y.product_id=z.product_id";
	             System.out.println("PrepareStatement: " + query);
	             psmt = conn.prepareStatement(query);
	             ResultSet rs = psmt.executeQuery();
	             
	            while (rs.next()) {
	                String warehouse_name = rs.getString("warehouse_name");
	                String product_name = rs.getString("product_name");
	                String quantity = rs.getString("quantity");
	                CityDTO vo = new CityDTO();
	                vo.setWarehouse_name(warehouse_name);
	                vo.setProduct_name(product_name);
	                vo.setQuantity(quantity);
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