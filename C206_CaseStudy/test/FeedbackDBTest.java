import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FeedbackDBTest {
	private Feedback fb1;
	private Feedback fb2;

	private ArrayList<Feedback> feedbackList;

	@Before
	public void setUp() throws Exception {
		// prepare test data
		fb1 = new Feedback("Tom", "Product not good", "Still pending solving","23/11/2012");
		fb2 = new Feedback("Ben", "Service is good", "Solved","26/10/2012");
		feedbackList = new ArrayList<Feedback>();
	}

	@Test
	public void retrieveAllFeedback() {
		// Feedback list is not null, so that can add a new feedback - boundary
		assertNotNull("Check if there is valid Feedback arraylist to add to", feedbackList);
		feedbackList.add(fb1);
		feedbackList.add(fb2);
		assertEquals("Check that Feedback arraylist size is 2", 2, feedbackList.size());

	}

	@Test
	public void addFeedbackTest() {
		// Feedback list is not null, so that can add a new feedback - boundary
		assertNotNull("Check if there is valid Feedback arraylist to add to", feedbackList);
		// After feedback is added Feedback list size should increase - normal
		feedbackList.add(fb1);
		assertEquals("Check that Feedback arraylist size is 1", 1, feedbackList.size());
		// Then check if correct Feedback was added
		assertSame("Check that Feedback is added", fb1, feedbackList.get(0));
	}

	@Test
	public void delFeedbackTest() {
		// Feedback list is not null, so that can add a new feedback - boundary
		assertNotNull("Check if there is valid Feedback arraylist to add to", feedbackList);
		feedbackList.add(fb1);
		feedbackList.add(fb2);
		// Given there are two feedbacks in the Feedback list when one feedback
		// is deleted than the feedback list size should decrease to one
		feedbackList.remove(fb1);
		assertEquals("Check that Feedback arraylist size is 1", 1, feedbackList.size());
		// Then check if the correct Feedback was deleted
		assertSame("Check that Feedback is added", fb2, feedbackList.get(0));
	}

	@Test
	public void searchFeedbackTest() {
		// Check feedback list is not null
		assertNotNull("Check if there is valid Feedback arraylist to add to", feedbackList);
		// Add Test Data
		FeedbackDB.populateFeedbackDB();
		feedbackList.add(fb1);
		feedbackList.add(fb2);
		assertEquals("Check that feedback arraylist size is 2", 2, feedbackList.size());
		// Test search function
		String output = String.format("%-4s %-10s %-30s %-30s %-15s\n", "ID", "CUSTOMER", "FEEDBACK", "RESPONSE", "DATE");
		String customer = feedbackList.get(1).getCustomer();
		String feedback = feedbackList.get(1).getFeedback();
		String response = feedbackList.get(1).getResponse();
		String date = feedbackList.get(1).getDate();
		output += String.format("%-4d %-10s %-30s %-30s %-15s\n", 1, customer,feedback, response, date);

		assertEquals("Check that feedback search gets the correct Feedback", output,
				FeedbackDB.searchFeedback("Tom"));
	}

	@After
	public void tearDown() throws Exception {
		fb1 = null;
		fb2 = null;
		feedbackList = null;
	}
}
