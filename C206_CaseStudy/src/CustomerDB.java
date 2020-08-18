/**
 /**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19026179, 13 Aug 2020 2:32:33 pm
 */
import java.util.ArrayList;
/**
 * @author 19026179
 *
 */
public class CustomerDB {
	
	public static ArrayList<Customer>customerList = new ArrayList<Customer>();
	
	//show menu 
	public static void ShowCustomerMenu() {
		Helper.line(40, "-");
		System.out.println("Customer Menu");
		Helper.line(40, "-");
		System.out.println("1. View all customers");
		System.out.println("2. Add customer");
		System.out.println("3. Delete customer");
		System.out.println("4. Quit");
	}
	

	// option 1
	public static void viewAllCustomer() {
		System.out.println(getAllCustomer());
	}
	/**
	 * @return
	 */
	private static String getAllCustomer() {
		// TODO Auto-generated method stub
		// get customer list
		int i = 0;
		String output = "";
		if(!customerList.isEmpty()) {
			output = String.format("%-10s %-10s %-20s %-10s\n","ID", "NAME", "EMAIL", "PHONE NUMBER");
			for (Customer c : customerList) {
				i ++;
				output += String.format("%-10s %-10s %-20s %-10s\n", i, c.getName(), c.getEmail(), c.getPhone());
			}
		}else {
			System.out.println("Invalid customer");
		}
		return output;
	}


	// option 2 
		public static void addCustomerDB(Customer customer) {
			customerList.add(customer);
			System.out.println("Customer added");
		} 
		

	//option 3
	public static void delCustomer(Customer customer) {
		customerList.remove(customer);
		System.out.println("Customer deleted");
		
	}
	
	public static void processOption() {
		int option = -1;
		while(option != 4) {
			ShowCustomerMenu();
			option = Helper.readInt("Enter option > ");
			if(option == 1) {
				// view customer
				viewAllCustomer();
				
			} else if (option == 2) {
				// add customer
				Customer customer = inputCustomerToAdd();
				addCustomerDB(customer);
				
			} else if (option == 3) {
				// delete customer
				int i = selectCustomerToDelete();
				try {
					delCustomer(customerList.get(i - 1));
					
				}catch(IndexOutOfBoundsException io ) {
					System.out.println(io.getMessage());
				}
				
				
			} else if (option == 4) {
				System.out.println("Thank you and goodbye");
			} else {
				System.out.println("Invalid option");
			}
		}
		
	}
	
	public static Customer inputCustomerToAdd() {
		String name = Helper.readString("Enter customer's name > ");
		String email = Helper.readString("Enter customer's email > ");
		int phone  = Helper.readInt("Enter customer's phone number > ");
		return new Customer();
		
	}
	
	public static int selectCustomerToDelete() {
		int id = Helper.readInt("Enter customer's ID > ");
		return id;
	
	}
}
