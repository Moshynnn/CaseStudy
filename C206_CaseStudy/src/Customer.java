/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19026179, 13 Aug 2020 2:32:23 pm
 */

/**
 * @author 19026179
 */
public class Customer {
	
	private String name;
	private String email;
	private String phone;
	
	
	public Customer(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString() {
		return null;
		
	}

}
