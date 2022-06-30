package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CustomerDTO;
import dto.ProductDTO;

public class CustomerDAO {

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

	public List<CustomerDTO> listproduct() {
		
		  List<CustomerDTO> list = new ArrayList<CustomerDTO>();
	        try {
	        	getConnection();
	             String query = "select * from customers ";
	             System.out.println("PrepareStatement: " + query);
	             psmt = conn.prepareStatement(query);
	             ResultSet rs = psmt.executeQuery();
	             
	            while (rs.next()) {
	                String customer_id = rs.getString("customer_id");
	                String name = rs.getString("name");
	                String address = rs.getString("address");
	                String website = rs.getString("website");
	                String credit_limit = rs.getString("credit_limit");
	                CustomerDTO vo = new CustomerDTO();
	                vo.setId(customer_id);
	                vo.setName(name);
	                vo.setAddress(address);
	                vo.setWebsite(website);
	                vo.setCreditlimit(credit_limit); 
	                list.add(vo);
	            }
	        } catch (SQLException e) { 
				e.printStackTrace();
			} finally {
				close();
			}
	         
	        return list; 
	    }
	
	public List slistcustomer(CustomerDTO customerVO) {
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
        String name_1 = customerVO.getName();
        try {
            getConnection();
            String query = "select * from customers";
            
            if((name_1 != null && name_1.length() != 0)) {
                query += " where name like '%' || ? || '%'";
                psmt = conn.prepareStatement(query);
                psmt.setString(1, name_1);
            }else {
                psmt = conn.prepareStatement(query);
            }
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                String customer_id = rs.getString("customer_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String website = rs.getString("website");
                String credit_limit = rs.getString("credit_limit");

                CustomerDTO vo = new CustomerDTO();
                vo.setId(customer_id);
                vo.setName(name);
                vo.setAddress(address);
                vo.setWebsite(website);
                vo.setCreditlimit(credit_limit); 
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