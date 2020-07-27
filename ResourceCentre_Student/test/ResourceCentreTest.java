import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	 public void addCamcorderTest() { //Done By Elson
        // Item list is not null, so that can add a new item
        assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
       
        //Given an empty list, after adding 1 item, the size of the list is 1
        ResourceCentre.addCamcorder(camcorderList, cc1);       
        assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
       
        //The item just added is as same as the first item of the list
        assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
       
        //Add another item. test The size of the list is 2?
        ResourceCentre.addCamcorder(camcorderList, cc2);
        assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	
	@Test
	public void addChromebookTest() { //Done By Brandon 18044455
		//fail("Not yet implemented");
		// Item list is not null, so that can add a new item
				assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
				//Given an empty list, after adding 1 item, the size of the list is 1
				ResourceCentre.addChromebook(chromebookList, cb1);		
				assertEquals("Test if that Camcorder arraylist size is 1?", 1, chromebookList.size());
				
				//The item just added is as same as the first item of the list
				assertSame("Test that Camcorder is added same as 1st item of the list?", cb1, chromebookList.get(0));
				
				//Add another item. test The size of the list is 2?
				ResourceCentre.addChromebook(chromebookList, cb2);
				assertEquals("Test that Camcorder arraylist size is 2?", 2, chromebookList.size());
	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
	}

	@Test
	
    public void doLoanCamcorderTest() {//Done By Yee Hung 19034609
  //fail("Not yet implemented");
  // write your code here
 
  //Given an empty list, after adding 2 items, test if the size of the list is 2
  ResourceCentre.addCamcorder(camcorderList, cc1);
  ResourceCentre.addCamcorder(camcorderList, cc2);
  assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
 
  // NORMAL
  //attempt to loan cc1, if loaned assert equal will succeed.
  ResourceCentre.doLoanCamcorder(camcorderList, cc1.getAssetTag(), "tomorrow");
  assertEquals("Test if Camcorder cc1 is loaned out", camcorderList.get(0).getDueDate(), "tomorrow");
 
  // ERROR
  // attempt to loan cc1 another time, expected to fail.
  ResourceCentre.doLoanCamcorder(camcorderList, cc1.getAssetTag(), "09/08/2020");
  assertNotEquals("Test if Camcorder cc1 is not loaned out twice", camcorderList.get(0).getDueDate(), "09/08/2020");
}

	
	@Test
	public void doLoanChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
	}
	
	@Test
	public void doReturnCamcorderTest() { //Done By Si Yuan 19016011
        // fail("Not yet implemented");
        // write your code here
        
        // boundary
        assertNotNull("Check if there is valid camcorder arraylist to add to", camcorderList);
        ResourceCentre.addCamcorder(camcorderList, cc1);


        // error
        Boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
        assertFalse("Check that available camcorder CC0011 is returned - false?", isReturned);


        // normal
        ResourceCentre.addCamcorder(camcorderList, cc2);
        cc2.setIsAvailable(false);
        isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0012");
        assertTrue("Check that loanded out camcorder CC0012 is returned - true", isReturned);
        // error
        isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0013");
        assertFalse("Check that available camcorder CC0011 is returned - false?", isReturned);

        }
	
	@Test
	public void doReturnChromebookTest() { //Done By Abdullah
        //fail("Not yet implemented");
        // write your code here
        //Given an empty list, after adding 2 items, test if the size of the list is 2
        ResourceCentre.addChromebook(chromebookList, cb1);
        ResourceCentre.addChromebook(chromebookList, cb2);
        assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
               
        //attempt to loan cb1, if loaned assert equal will succeed.
        ResourceCentre.doLoanChromebook(chromebookList, cb1.getAssetTag(), "24/7/2020");
        assertEquals("Test if Chromebook cb1 is loaned out", chromebookList.get(0).getDueDate(), "24/7/2020");
               
        // NORMAL
        // attempt to return cb1, if returned success, assert equal will succeed.
        ResourceCentre.doReturnChromebook(chromebookList, cb1.getAssetTag());
        assertEquals("Test if Chromebook cb1 is returned", chromebookList.get(0).getDueDate(), "");
               
        // ERROR
        // attempt to return cb2, when its not loan out.
        assertFalse(ResourceCentre.doReturnChromebook(chromebookList, cb2.getAssetTag()));
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
