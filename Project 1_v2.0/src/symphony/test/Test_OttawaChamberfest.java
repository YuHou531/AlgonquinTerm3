package symphony.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.OttawaChamberfest;

/**
 * JUnit test OttawaChamberfest class from symphony.domain package
 */
public class Test_OttawaChamberfest extends TestCase {
	
	public Test_OttawaChamberfest(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_OttawaChamberfest.class);		}

	protected void setUp() throws Exception { System.out.println("Test_OttawaChamberfest Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_OttawaChamberfest End");	}

	/**
	 * Test constructor with arguents
	 */
	public void testConstructor() {
		
		System.out.println("\tExecuting Test_OttawaChamberfest.testConstructor");
		
		assertNull("\t\tTest_OttawaChamberfest.testConstructor", ocVenue);
		
		ocVenue = new OttawaChamberfest("101");
		
		assertNotNull("\t\tTest_OttawaChamberfest.testConstructor", ocVenue);
	}
	
	/**
	 * test hasDiscount()
	 */
    public void testBehaviors() {
		
		System.out.println("\tExecuting Test_OttawaChamberfest.testBehaviors");
		
		ocVenue = new OttawaChamberfest("101");
		
		assertFalse("\t\tTest_OttawaChamberfest.testBehaviors", ocVenue.hasDiscount());
	}
    
    /**
     * test setSeats()
     */
    public void testMutators() {
		
		System.out.println("\tExecuting Test_OttawaChamberfest.testMutators");
		
		ocVenue = new OttawaChamberfest("101");
		ocVenue.setSeats(1000);
		
		assertTrue("\t\tTest_OttawaChamberfest.testMutators", 1000 == ocVenue.getSeat(999));

	}
    
    /**
     * test getSeat(), getAddress()
     */
    public void testAccessors() {
		
		System.out.println("\tExecuting Test_OttawaChamberfest.testAccessors");
		
		ocVenue = new OttawaChamberfest("101");
		ocVenue.setSeats(1000);
		
		assertTrue("\t\tTest_OttawaChamberfest.testAccessors", ocVenue.getAddress().equals("101"));
		
		assertTrue("\t\tTest_OttawaChamberfest.testAccessors", 101 == ocVenue.getSeat(100));
	}

	/* ATTRIBUTES	-----------------------------------------------	*/
	private OttawaChamberfest ocVenue;

}	


