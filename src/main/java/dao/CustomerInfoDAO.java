package dao;


	import java.sql.Connection;

	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import dto.CustomerInfoDTO;
import dto.CustomerDTO;
import dto.ProductDTO;
	

	public class CustomerInfoDAO {

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

		public List slistcustomer(CustomerInfoDTO customerInfoVO) {
			List<CustomerInfoDTO> list = new ArrayList<CustomerInfoDTO>();
	        int Customer_id = customerInfoVO.getCustomer_id();
	        try {
	            getConnection();
	            System.out.println(Customer_id);
	            String query = "select  x.customer_id, x.order_id, x.status, x.order_date, z.product_name, y.quantity, y.unit_price, z.standard_cost  from orders X , order_items Y , products Z where x.order_id  = y.order_id and y.product_id  = z.product_id";
	            if(true) {
	                query += " and x.customer_id like ?";
	                psmt = conn.prepareStatement(query);
	                psmt.setInt(1, Customer_id);
	            }else {
	                psmt = conn.prepareStatement(query);
	            }
	            ResultSet rs = psmt.executeQuery();
	            while (rs.next()) {
	                String order_id = rs.getString("order_id");
	                int customer_id = rs.getInt("customer_id");
	                String status = rs.getString("status");
	                String product_name = rs.getString("product_name");
	                String order_date = rs.getString("order_date");
	                String quantity = rs.getString("quantity");
	                String unit_price = rs.getString("unit_price");
	                String standard_cost = rs.getString("standard_cost");

	                CustomerInfoDTO vo = new CustomerInfoDTO();
	                vo.setCustomer_id(customer_id);
	                vo.setOrder_id(order_id);
	                vo.setStatus(status);
	                vo.setProduct_name(product_name);
	                vo.setQuantity(quantity);
	                vo.setUnit_price(unit_price);
	                vo.setStandard_cost(standard_cost);
	                vo.setOrder_date(order_date); 
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