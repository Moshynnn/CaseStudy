
public class Feedback {
	
	private String customer;
	private String feedback;
	private String response;
	public String getCustomer() {
		return customer;
	}
	
	public Feedback(String customer, String feedback, String response) {
		super();
		this.customer = customer;
		this.feedback = feedback;
		this.response = response;
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
	@Override
	public String toString() {
		return "Feedback [customer=" + customer + ", feedback=" + feedback + ", response=" + response + "]";
	}
	
	
}
