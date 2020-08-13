import java.util.ArrayList;

public class BikeDB {

	private static ArrayList<Bike> bikeList = new ArrayList<Bike>();

	public static void populateBikeDB() {
		// add some data to the list

	}

	public static void cleanupBikeDB() {
		// clean up the data in the list

	}

	public static void handleBikeOptions() {
		// show bike menu, ask user for input, process the choice
		int subOption = 0;

	}

	public static void showBikeMenu() {
		// Display the menu
	}

	public static void processOption(int subOption) {

		while (subOption != 4) {
			if (subOption == 1) {
				// View all bike

			} else if (subOption == 2) {
				// Add a bike

			} else if (subOption == 3) {
				// Delete a bike

			} else {
				// invalid option
				System.out.println("Invalid type");
			}

			// show the menu again & ask for option

		}

	}

	// ==========Option 1 ==============
	public static void viewAllBike() {
		// display all bikes in the list
	}

	public static String retrieveAllBike() {
		// retrieve and format all bikes in the list
	}

	// ==========Option 2 ==============
	public static Bike inputBikeDetails() {
		// request user for the bike to add to the list
	}

	public static void addBike(Bike bk) {
		// add bike to list

	}

	// ==========Option 3 ==============
	public static int selectBike() {
		// request the user to select bike for process
	}

	public static void delBike(int bikeID) {
		// remove bike to list

	}

	// ==============Helper Functions=======
	public static int getBikeDBSize() {
		return bikeList.size();
	}

	public static String getBikeInfo(int bikeID) {
		// format and return the string
	}
}
