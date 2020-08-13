import java.util.ArrayList;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19028690, 11 Aug 2020 4:01:31 pm
 */
// Created by Chad on 10/08/2020
public class AppointmentDB {

	private static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

	public static void populateAppointmentDB() {
		// add some data to the list
		Appointment ap1 = new Appointment("John", "11/08/2020", "22:08");
		Appointment ap2 = new Appointment("James", "15/08/2020", "23:08");
		appointmentList.add(ap1);
		appointmentList.add(ap2);
	}

	public static void cleanupAppointmentDB() {
		// clean up the data in the list
		appointmentList.clear();
	}

	public static void handleAppointmentOptions() {
		// show bike menu, ask user for input, process the choice
		int subOption = 0;
		processOption(subOption);
	}

	public static void showAppointmentMenu() {
		Helper.line(50, "=");
		System.out.println("APPOINTMENT MENU");
		Helper.line(50, "=");
		System.out.println("1. View All Appointment");
		System.out.println("2. Add Appointment");
		System.out.println("3. Delete Appointment");
		System.out.println("4. Back");
	}

	public static void processOption(int subOption) {
		while (subOption != 4) {
			showAppointmentMenu();
			subOption = Helper.readInt("Enter Option > ");
			if (subOption == 1) {
				// View all Appointment
				viewAllAppointment();
			} else if (subOption == 2) {
				// Add a Appointment
				Appointment a = inputAppointmentToAdd();
				addAppointment(a);
			} else if (subOption == 3) {
				// Delete a Appointment
				int i = selectAppointmentToDelete();
				try {
					delAppointment(getAppointmentArrayList().get(i - 1));
				} catch (IndexOutOfBoundsException e) {
					System.out.println(e.getMessage());
				}
			} else if (subOption == 4) {
				System.out.println("Appointment Menu Closed");
			} else {
				System.out.println("Invalid Option");
			}
		}

	}

	// ========== Option 1 ==============
	public static void viewAllAppointment() {
		System.out.println(retrieveAllAppointment());
	}

	public static String retrieveAllAppointment() {
		// retrieve and format all Appointment in the list
		int i = 0;
		String output = "";
		if (!getAppointmentArrayList().isEmpty()) {
			output = String.format("%-5S%-15S%-15S%S\n", "ID", "NAME", "DATE", "TIME");
			for (Appointment a : getAppointmentArrayList()) {
				i++;
				output += String.format("%-5S%-15S%-15S%S\n", i, a.getCustomerName(), a.getDate(), a.getTime());
			}
		} else {
			output += "No Appointments in the Database";
		}
		return output;
	}

	// ========== Option 2 ==============
	public static Appointment inputAppointmentToAdd() {
		String name = Helper.readString("Enter Name > ");
		String date = Helper.readString("Enter Date (DD/MM/YY) > ");
		String time = Helper.readString("Enter Time in 24 Hour Format (HH:MM) > ");
		return new Appointment(name, date, time);
	}

	public static void addAppointment(Appointment a) {
		getAppointmentArrayList().add(a);
		System.out.println("Appointment added");
	}

	// ========== Option 3 ==============
	public static int selectAppointmentToDelete() {
		int id = Helper.readInt("Enter Appointment ID > ");
		return id;
	}

	public static void delAppointment(Appointment a) {
		getAppointmentArrayList().remove(a);
		System.out.println("Appointment deleted");
	}

	// ============== Helper Functions=======
	public static ArrayList<Appointment> getAppointmentArrayList() {
		return appointmentList;
	}

	public static void setAppointmentArrayList(ArrayList<Appointment> a) {
		appointmentList = a;
	}

}
