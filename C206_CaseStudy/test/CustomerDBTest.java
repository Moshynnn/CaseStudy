import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19026179, 18 Aug 2020 12:00:48 pm
 */

/**
 * @author 19026179
 *
 */
public class CustomerDBTest {

	private Customer c1;
	private Customer c2;

	private ArrayList<Customer> customerList;

	@Before
	public void setUp() throws Exception {
		// prepare data given
		c1 = new Customer("John", "john@123.com", "98769876");
		c2 = new Customer("James", "james@yahoo.com", "87879999");

		CustomerDB.setCustomer(new ArrayList<Customer>());

	}

	@Test
	public void getAllCustomer() {
		assertNotNull("Check if there is valid customerList to add", CustomerDB.getCustomerList());
		CustomerDB.addCustomerDB(c1);
		CustomerDB.addCustomerDB(c2);
		assertEquals("Check customerList size is 2", 2, CustomerDB.getCustomerList().size());
	}

	@Test
	public void addCustomerTest() {
		assertNotNull("Check if there is valid customerList to add", CustomerDB.getCustomerList());
		CustomerDB.addCustomerDB(c1);
		assertEquals("Check customerList size is 1", 1, CustomerDB.getCustomerList().size());
		assertSame("Check customer is added", c1, CustomerDB.getCustomerList().get(0));
	}

	@Test
	public void delCustomerTest() {
		assertNotNull("Check if there is valid customerList to add", CustomerDB.getCustomerList());
		CustomerDB.addCustomerDB(c1);
		CustomerDB.addCustomerDB(c2);
		CustomerDB.delCustomer(c1);
		assertEquals("Check customerList size is 1", 1, CustomerDB.getCustomerList().size());
		assertSame("Check customer is added", c2, CustomerDB.getCustomerList().get(0));
	}

	@After

	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
		CustomerDB.setCustomer(customerList);
	}

}
