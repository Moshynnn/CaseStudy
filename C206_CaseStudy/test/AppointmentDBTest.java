import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19028690, 11 Aug 2020 10:06:38 pm
 */
// Created by Chad on 10/08/2020
public class AppointmentDBTest {

	private Appointment ap1;
	private Appointment ap2;

	private ArrayList<Appointment> appointmentList;

	@Before
	public void setUp() throws Exception {
		// prepare test data
		ap1 = new Appointment("John", "11/08/2020", "22:08");
		ap2 = new Appointment("James", "15/08/2020", "23:08");
		appointmentList = new ArrayList<Appointment>();
	}

	@Test
	public void retrieveAllAppointment() {
		// Appointment list is not null, so that can add a new appointment - boundary
		assertNotNull("Check if there is valid Appointment arraylist to add to", appointmentList);
		appointmentList.add(ap1);
		appointmentList.add(ap2);
		assertEquals("Check that Appointment arraylist size is 2", 2, appointmentList.size());

	}

	@Test
	public void addAppointmentTest() {
		// Appointment list is not null, so that can add a new appointment - boundary
		assertNotNull("Check if there is valid Appointment arraylist to add to", appointmentList);
		// After appointment is added Appointment list size should increase - normal
		appointmentList.add(ap1);
		assertEquals("Check that Appointment arraylist size is 1", 1, appointmentList.size());
		// Then check if correct Appointment was added
		assertSame("Check that Appointment is added", ap1, appointmentList.get(0));
	}

	@Test
	public void delAppointmentTest() {
		// Appointment list is not null, so that can add a new appointments - boundary
		assertNotNull("Check if there is valid Appointment arraylist to add to", appointmentList);
		appointmentList.add(ap1);
		appointmentList.add(ap2);
		// Given there are two appointments in the Appointment list when one appointment
		// is deleted than the Appointment list size should decrease to one
		appointmentList.remove(ap1);
		assertEquals("Check that Appointment arraylist size is 1", 1, appointmentList.size());
		// Then check if the correct Appointment was deleted
		assertSame("Check that Appointment is added", ap2, appointmentList.get(0));
	}

	@Test
	public void searchAppointmentTest() {
		assertNotNull("Check if there is valid Appointment arraylist to add to", appointmentList);
		// Add Test Data
		AppointmentDB.populateAppointmentDB();
		appointmentList.add(ap1);
		appointmentList.add(ap2);
		assertEquals("Check that Appointment arraylist size is 2", 2, appointmentList.size());
		// Test search function
		String output = String.format("%-5S%-15S%-15S%S\n", "ID", "NAME", "DATE", "TIME");
		String customerName = appointmentList.get(1).getCustomerName();
		String date = appointmentList.get(1).getDate();
		String time = appointmentList.get(1).getTime();
		output += String.format("%-5S%-15S%-15S%S\n", 1, customerName, date, time);

		assertEquals("Check that Appointment search gets the correct Appointment", output,
				AppointmentDB.searchAppointment("james"));
	}

	@After
	public void tearDown() throws Exception {
		ap1 = null;
		ap2 = null;
		appointmentList = null;
	}

}
