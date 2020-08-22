import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BikePartDBTest {

	
	private BikePart bp1;
	private BikePart bp2;
	
	private ArrayList<BikePart> bikepartList;
	
	@Before
	
	public void setUp() throws Exception {
		// prepare test data
		bp1 = new BikePart("Tyre", "BMX type 1", 22.50);
		bp2 = new BikePart("Seat", "Adjustable leather", 48.20);
		BikePartsDB.setBikePartList(new ArrayList<BikePart>());
	}
	@Test
	public void retrieveAllBikePart() {
		// BikePart List is not null, so that can add a new bike part - boundary
		assertNotNull("Check if there is valid Bikeparts arraylist to add to", BikePartsDB.getBikePartList());
		BikePartsDB.addBikePart(bp1);
		BikePartsDB.addBikePart(bp2);
		assertEquals("Check that Bikepart arraylist size is 2", 2, BikePartsDB.getBikePartList().size());

	}
	@Test
	public void addBikePartTest() {
		// BikePart list is not null, so that can add a new bike part - boundary
		assertNotNull("Check if there is valid Bikepart arraylist to add to", BikePartsDB.getBikePartList());
		// After BikePart is added BikePart list size should increase - normal
		BikePartsDB.addBikePart(bp1);
		assertEquals("Check that Bikepart arraylist size is 1", 1, BikePartsDB.getBikePartList().size());
		// Then check if correct Bike part was added
		assertSame("Check that Bike part is added", bp1, BikePartsDB.getBikePartList().get(0));
	}
	
	@Test
	public void delBikePartTest() {
		// BikePart list is not null, so that can add a new BikeParts - boundary
		assertNotNull("Check if there is valid BikePart arraylist to add to", BikePartsDB.getBikePartList());
		BikePartsDB.addBikePart(bp1);
		BikePartsDB.addBikePart(bp2);
		// Given there are two BikeParts in the BikePart list when one BikePart
		// is deleted than the BikePart list size should decrease to one
		BikePartsDB.delBikePart(bp1);
		assertEquals("Check that BikePart arraylist size is 1", 1, BikePartsDB.getBikePartList().size());
		// Then check if the correct BikePart was deleted
		assertSame("Check that BikePart is added", bp2, BikePartsDB.getBikePartList().get(0));
	}
	
	@Test
	public void updBikePartTest() {
		assertNotNull("Check if there is valid BikePart arraylist to add to", BikePartsDB.getBikePartList());
		BikePartsDB.addBikePart(bp1);
		
		
		// Create variable to update bike part an ID and New name of the Bike part
		
		BikePartsDB.updateBikePart(1, "Gear");
		
		// Checking whether the name was successfully updated. 
		assertSame("Check that BikePart name is updated", "Gear", BikePartsDB.getBikePartList().get(0).getName());
	}
	
}

