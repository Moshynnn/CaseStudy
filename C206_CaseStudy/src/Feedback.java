
public class Feedback {
	
	private String customer;
	private String feedback;
	private String response;
	private String date;
	
	public String getCustomer() {
		return customer;
	}
	
	public Feedback(String customer, String feedback, String response,String date) {
		super();
		this.customer = customer;
		this.feedback = feedback;
		this.response = response;
		this.date = date;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Feedback [customer=" + customer + ", feedback=" + feedback + ", response=" + response + ", date=" + date
				+ "]";
	}
	
	
	
	
}
