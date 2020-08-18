
public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {

		// insert initial data

//		CustomerDB.populateBikeDB();
		BikePartsDB.populateBikePartDB(); // Create by Muhsin on 17/08/2020
		AppointmentDB.populateAppointmentDB(); // Create by Chad on 10/08/2020

		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.showMainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Call CustomerDB
//				CustomerDB.handleBikeOptions();
			} else if (option == 2) {
				// Call BikePartDB menu
				BikePartsDB.handleBikePartOptions(); // Create by Muhsin on 17/08/2020
			} else if (option == 3) {
				// Call Feedback menu

			} else if (option == 4) {
				// Call Appointment menu
				AppointmentDB.handleAppointmentOptions(); // Created by Chad on 10/08/2020
			} else if (option == 5) {
				// quit
				System.out.println("Program Terminated"); // Created by Chad on 10/08/2020
			}

		}

		// clean up data
//		CustomerDB.cleanupBikeDB();

		AppointmentDB.cleanupAppointmentDB(); // Created by Chad on 10/08/2020
		BikePartsDB.cleanupBikePartDB(); // Create by Muhsin on 17/08/2020
	}

	public static void showMainMenu() { // Created by Chad on 10/08/2020
		// insert your menu here
		Helper.line(50, "=");
		System.out.println("BIKE LOVER'S COMMUNITY MANAGER");
		Helper.line(50, "=");
		System.out.println("1. Customer Menu");
		System.out.println("2. Bike Part Menu");
		System.out.println("3. Feedback Menu");
		System.out.println("4. Appointment Menu");
		System.out.println("5. Quit");
	}

}
