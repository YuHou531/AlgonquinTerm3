package symphony.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.AlgonquinCommonsTheatre;
import symphony.domain.OttawaChamberfest;
import symphony.domain.Soloist;

/**
 * JUnit test AlgonquinCommonsTheatre class 
 */
public class Test_AlgonquinCommonsTheatre extends TestCase {
	
	public Test_AlgonquinCommonsTheatre(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_AlgonquinCommonsTheatre.class);		}

	protected void setUp() throws Exception { System.out.println("Test_AlgonquinCommonsTheatre Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_AlgonquinCommonsTheatre End");	}

	/**
	 * Test constructor
	 */
	public void testConstructor() {
		
		System.out.println("\tExecuting Test_AlgonquinCommonsTheatre.testConstructor");
		
		assertNull("\t\tTest_AlgonquinCommonsTheatre.testConstructor", algonquin);
		
		algonquin = new AlgonquinCommonsTheatre("1385");
		
		assertNotNull("\t\tTest_AlgonquinCommonsTheatre.testConstructor", algonquin);
	}
	
	/**
	 * test hasDiscount()
	 */
    public void testBehaviors() {
		
		System.out.println("\tExecuting Test_AlgonquinCommonsTheatre.testBehaviors");
		
		algonquin = new AlgonquinCommonsTheatre("1385");
		
		assertTrue("\t\tTest_AlgonquinCommonsTheatre.testBehaviors", algonquin.hasDiscount());
	}
    
    /**
     * test setSeats()
     */
    public void testMutators() {
		
		System.out.println("\tExecuting Test_AlgonquinCommonsTheatre.testMutators");
		
		algonquin = new AlgonquinCommonsTheatre("1385");
		algonquin.setSeats(1000);
		
		assertTrue("\t\tTest_AlgonquinCommonsTheatre.testMutators", 1000 == algonquin.getSeat(999));
		
	}
    
    /**
     * test getSeat()
     */
    public void testAccessors() {
		
		System.out.println("\tExecuting Test_AlgonquinCommonsTheatre.testAccessors");
		
		algonquin = new AlgonquinCommonsTheatre("1385");
		algonquin.setSeats(1000);
		
		assertFalse("\t\tTest_AlgonquinCommonsTheatre.testAccessors", algonquin.getAddress().equals("101"));
		assertTrue("\t\tTest_AlgonquinCommonsTheatre.testAccessors", algonquin.getAddress().equals("1385"));
		
		assertTrue("\t\tTest_AlgonquinCommonsTheatre.testAccessors", 101 == algonquin.getSeat(100));
		assertTrue("\t\tTest_AlgonquinCommonsTheatre.testAccessors", 1 == algonquin.getSeat(0));

	}

	/* ATTRIBUTES	-----------------------------------------------	*/
	private AlgonquinCommonsTheatre algonquin;

}	


