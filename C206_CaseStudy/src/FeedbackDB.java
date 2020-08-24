import java.util.ArrayList;

public class FeedbackDB {

		private static ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();

		public static void populateFeedbackDB() {
			//adding feedback to the list
			Feedback f1 = new Feedback("Tom", "Product not good", "Still pending solving","23/11/2012");
			Feedback f2 = new Feedback("Ben", "Service is good", "Solved","26/10/2012");
			feedbackList.add(f1);
			feedbackList.add(f2);
		}
		
		public static void cleanupFeedbackDB() {
			//cleaning the list
			feedbackList.clear();
		}
		
		public static void handleFeedbackOptions() {
			//show feedback, ask user, process the option.
			int subOption = 0;
			processOption(subOption);
		}
		
		public static void showFeedbackMenu() {
			Helper.line(50, "=");
			System.out.println("Feedback MENU");
			Helper.line(50, "=");
			System.out.println("1. View All Feedback");
			System.out.println("2. Add a Feedback");
			System.out.println("3. Delete Feedback");
			System.out.println("4. Search Feedback by date");
			System.out.println("5. Back");
		}
		public static void processOption(int subOption) {
			while (subOption != 4) {
				showFeedbackMenu();
				subOption = Helper.readInt("Enter Option > ");
				if (subOption == 1) {
					// View all Feedback
					viewAllFeedback();
				} else if (subOption == 2) {
					// Add Feedback
					Feedback f = inputFeedbackToAdd();
					addFeedback(f);
				} else if (subOption == 3) {
					// Delete Feedback
					int i = selectFeedbackToDelete();
					try {
						delFeedback(feedbackList.get(i - 1));
					} catch (IndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
					}
					//Search feedback by date
				} else if (subOption == 4) {
					String date = Helper.readString("Enter feedback date (dd/mm/yyyy)> ");
					System.out.println(searchFeedback(date));
					//Quit
				} else if (subOption == 5) {
					System.out.println("Feedback Menu Closed");
				} else {
					System.out.println("Invalid Option");
				}
			}
		}	
		
		// ========== Option 1 ==============
		public static void viewAllFeedback( ) {	
			System.out.println(RetrieveAllFeedback());
				
			}
		private static String RetrieveAllFeedback() {
			int i = 0;
			String output = "";
			if (!feedbackList.isEmpty()) {
				output = String.format("%-4s %-10s %-30s %-30s %-15s\n","ID","CUSTOMER", "FEEDBACK", "RESPONSE", "DATE");
				for (Feedback f : feedbackList) {
					i++;
					output += String.format("%-4d %-10s %-30s %-30s %-15s\n", i, f.getCustomer(), f.getFeedback(), f.getResponse(),f.getDate());
				}
			} else {
				output += "No Feedback";
			}
			return output;
		}
			
		// ========== Option 2 ==============
			public static Feedback inputFeedbackToAdd() {
				String Customer = Helper.readString("Enter customer name > ");
				String Feedback = Helper.readString("Enter feedback of customer > ");
				String Response = Helper.readString("Enter response > ");
				String Date =  Helper.readString("Enter date of feedback (dd/mm/yyyy)> ");
				return new Feedback(Customer, Feedback, Response,Date);
			}

			public static void addFeedback(Feedback f) {
				feedbackList.add(f);
				System.out.println("Feedback added");
			}

		// ========== Option 3 ==============
			public static int selectFeedbackToDelete() {
				int id = Helper.readInt("Enter Feedback ID > ");
				return id;
			}

			public static void delFeedback(Feedback f) {
				feedbackList.remove(f);
				System.out.println("Feedback deleted");
			}
		//================ Option 4 =============
		public static String searchFeedback(String date) {
			boolean hasFeedback = false;
			String output = "";
			int i = 0;
			if (feedbackList.isEmpty()) {
				output += "No Feedbacks in the Database";
			} else {
				output = String.format("%-4s %-10s %-30s %-30s %-15s\n", "ID", "CUSTOMER", "FEEDBACK", "RESPONSE", "DATE");
				for (Feedback f : feedbackList) {
					if (f.getDate().equals(date)) {
						i++;
						output += String.format("%-4d %-10s %-30s %-30s %-15s\n", i, f.getCustomer(), f.getFeedback(), f.getResponse(),f.getDate());
						hasFeedback = true;
					}
				}
			}
			if (!hasFeedback) {
				output = "There are no feedback in the date" ;
			}
			return output;
		}

			// ============== Helper Functions=======
			public static ArrayList<Feedback> getfeedbackList() {
				return feedbackList;
			}

			public static void setFeedbackList(ArrayList<Feedback> f) {
				feedbackList = f ;
			
		}
			
		}


