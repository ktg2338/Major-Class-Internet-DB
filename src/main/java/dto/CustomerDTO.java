package dto;

public class CustomerDTO {
	private String id;
	private String name;
	private String address;
	private String website;
	private String creditlimit;
	
	public CustomerDTO() {

	}

	public CustomerDTO(String id, String name, String address, String website, String creditlimit) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.website = website;
		this.creditlimit = creditlimit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCreditlimit() {
		return creditlimit;
	}

	public void setCreditlimit(String creditlimit) {
		this.creditlimit = creditlimit;
	}
	
	
	
	
	
	
	

}
