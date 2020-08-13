/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19028690, 11 Aug 2020 4:01:20 pm
 */
// Create by Chad on 10/08/2020
public class Appointment {

	private String customerName;
	private String date;
	private String time;

	public Appointment(String customerName, String date, String time) {
		this.customerName = customerName;
		this.date = date;
		this.time = time;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
