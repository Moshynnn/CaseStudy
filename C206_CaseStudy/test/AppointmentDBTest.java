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

	private ArrayList<Appointment> appointmentAList;

	@Before
	public void setUp() throws Exception {
		// prepare test data
		ap1 = new Appointment("John", "11/08/2020", "22:08");
		ap2 = new Appointment("James", "15/08/2020", "23:08");
		AppointmentDB.setAppointmentList(new ArrayList<Appointment>());
	}

	@Test
	public void retrieveAllAppointment() {
		// Appointment list is not null, so that can add a new appointment - boundary
		assertNotNull("Check if there is valid Appointment arraylist to add to", AppointmentDB.getAppointmentList());
		AppointmentDB.addAppointment(ap1);
		AppointmentDB.addAppointment(ap2);
		assertEquals("Check that Appointment arraylist size is 2", 2, AppointmentDB.getAppointmentList().size());
		
	}

	@Test
	public void addAppointmentTest() {
		// Appointment list is not null, so that can add a new appointment - boundary
		assertNotNull("Check if there is valid Appointment arraylist to add to", AppointmentDB.getAppointmentList());
		// After appointment is added Appointment list size should increase - normal
		AppointmentDB.addAppointment(ap1);
		assertEquals("Check that Appointment arraylist size is 1", 1, AppointmentDB.getAppointmentList().size());
		// Then check if correct Appointment was added
		assertSame("Check that Appointment is added", ap1, AppointmentDB.getAppointmentList().get(0));
	}

	@Test
	public void delAppointmentTest() {
		// Appointment list is not null, so that can add a new appointments - boundary
		assertNotNull("Check if there is valid Appointment arraylist to add to", AppointmentDB.getAppointmentList());
		AppointmentDB.addAppointment(ap1);
		AppointmentDB.addAppointment(ap2);
		// Given there are two appointments in the Appointment list when one appointment
		// is deleted than the Appointment list size should decrease to one
		AppointmentDB.delAppointment(ap1);
		assertEquals("Check that Appointment arraylist size is 1", 1, AppointmentDB.getAppointmentList().size());
		// Then check if the correct Appointment was deleted
		assertSame("Check that Appointment is added", ap2, AppointmentDB.getAppointmentList().get(0));
	}

	@After
	public void tearDown() throws Exception {
		ap1 = null;
		ap2 = null;
		AppointmentDB.setAppointmentList(null);
	}

}
