package dto;

public class CustomerInfoDTO {
	private String order_id;
	private int customer_id;
	private String status;
	private String salesman_id;
	private String order_date;
	private String product_name;
	private String quantity;
	private String unit_price;
	private String standard_cost;
	

    
    
	public CustomerInfoDTO() {
		super();
	}
	public CustomerInfoDTO(String order_id, int customer_id, String status, String salesman_id, String order_date,
			String product_name, String quantity, String unit_price, String standard_cost) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.status = status;
		this.salesman_id = salesman_id;
		this.order_date = order_date;
		this.product_name = product_name;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.standard_cost = standard_cost;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}
	public String getStandard_cost() {
		return standard_cost;
	}
	public void setStandard_cost(String standard_cost) {
		this.standard_cost = standard_cost;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSalesman_id() {
		return salesman_id;
	}
	public void setSalesman_id(String salesman_id) {
		this.salesman_id = salesman_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	
	
}
	