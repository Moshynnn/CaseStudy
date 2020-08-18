import java.util.ArrayList;

public class BikePartsDB {

	private static ArrayList<BikePart> bikepartList = new ArrayList<BikePart>();

	
	public static void populateBikePartDB() {
		// add some data to the list
		BikePart bp1 = new BikePart("Tyre", "BMX type 1", 22.50);
		BikePart bp2 = new BikePart("Seat", "Adjustable leather", 48.20);
		bikepartList.add(bp1);
		bikepartList.add(bp2);
	}
	public static void cleanupBikePartDB() {
		// clean up the data in the list
		bikepartList.clear();
	}
	public static void handleBikePartOptions() {
		// show bike menu, ask user for input, process the choice
		int subOption = 0;
		processOption(subOption);
	}
	
	public static void showBikePartMenu() {
		Helper.line(50, "=");
		System.out.println("Bikepart MENU");
		Helper.line(50, "=");
		System.out.println("1. View All Bikeparts");
		System.out.println("2. Add a Bikepart");
		System.out.println("3. Delete BikePart");
		System.out.println("4. Back");
	}
	
	public static void processOption(int subOption) {
		while (subOption != 4) {
			showBikePartMenu();
			subOption = Helper.readInt("Enter Option > ");
			if (subOption == 1) {
				// View all Appointment
				viewAllBikepart();
			} else if (subOption == 2) {
				// Add a Appointment
				BikePart bp = inputBikePartToAdd();
				addBikePart(bp);
			} else if (subOption == 3) {
				// Delete a Appointment
				int i = selectBikePartToDelete();
				try {
					delBikePart(bikepartList.get(i - 1));
				} catch (IndexOutOfBoundsException e) {
					System.out.println(e.getMessage());
				}
			} else if (subOption == 4) {
				System.out.println("Bikepart Menu Closed");
			} else {
				System.out.println("Invalid Option");
			}
		}
	}
	
	
	
	// ========== Option 1 ==============
	public static void viewAllBikepart() {
		System.out.println(retrieveAllBikePart());get
	}
	
	public static String retrieveAllBikePart() {
		// retrieve and format all Bikepart in the list
		int i = 0;
		String output = "";
		if (!bikepartList.isEmpty()) {
			output = String.format("%-5S%-11S%-16S %S\n", "ID", "NAME", "DESC", "PRICE");
			for (BikePart b : bikepartList) {
				i++;
				output += String.format("%-4S %-10S %-15S %.2f \n", i, b.getName(), b.getDescription(), b.getPrice());
			}
		} else {
			output += "No bikeparts available";
		}
		return output;
	}
	
	// ========== Option 2 ==============
		public static BikePart inputBikePartToAdd() {
			String part = Helper.readString("Enter Bike part Name > ");
			String desc = Helper.readString("Enter description for bike part > ");
			double price = Helper.readDouble("Enter Price of bike part > ");
			return new BikePart(part, desc, price);
		}

		public static void addBikePart(BikePart bp) {
			bikepartList.add(bp);
			System.out.println("Bike part added");
		}

	// ========== Option 3 ==============
		public static int selectBikePartToDelete() {
			int id = Helper.readInt("Enter BikePart ID > ");
			return id;
		}

		public static void delBikePart(BikePart bp) {
			bikepartList.remove(bp);
			System.out.println("BikePart deleted");
		}

		// ============== Helper Functions=======
		public static ArrayList<BikePart> getBikePartList() {
			return bikepartList;
		}

		public static void setBikePartList(ArrayList<BikePart> bp) {
			bikepartList = bp ;
		}
			
}
