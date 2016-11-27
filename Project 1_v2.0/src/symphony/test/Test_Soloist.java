package symphony.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.Soloist;

/**
 * JUint test Soloist class from symphony.domain package
 */
public class Test_Soloist extends TestCase {
	
	public Test_Soloist(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_Soloist.class);		}

	protected void setUp() throws Exception { System.out.println("Test_Soloist Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_Soloist End");	}

	/**
	 * Test the Builder Pattern.
	 */
	public void testSoloistBuilderConstructor() {
		
		System.out.println("\tExecuting Test_Soloist.testBuilderConstructor");
		soloist = (Soloist) new Soloist.Builder("solo 1", "Lang Lang")
				.addPhone("123-456").addAddress("88 Bay").addExpertise("piano").build();
		
		assertNotNull("\t\tTest_Soloist.testSoloistBuilder: Soloist is null", soloist);
		
		assertTrue("\t\tTest_Soloist.testSoloistBuilder: builder.addPhone is wrong", soloist.getPhone().equals("123-456"));
		
		assertTrue("\t\tTest_Soloist.testSoloistBuilder: builder.addAddress is wrong", soloist.getAddress().equals("88 Bay"));
		
		assertTrue("\t\tTest_Soloist.testSoloistBuilder: builder.addExpertise is wrong", soloist.getExpertises().get(0).equals("piano"));
		
		assertTrue("\t\tTest_Soloist.testSoloistBuilder: builder.constructor is wrong",
														soloist.getID().equals("solo 1")&&soloist.getName().equals("Lang Lang"));	
	}
	
	/**
	 * test getExpertise()
	 */
    public void testSoloistBehaviors() {
		
		System.out.println("\tExecuting Test_Soloist.testBehaviors");
		soloist = (Soloist) new Soloist.Builder("solo 2", "Yundi Li")
				.addAddress("China").addExpertise("piano").addExpertise("saxophone").build();
		
		assertTrue("\t\tTest_Soloist.testSoloistBuilder: builder.addExpertise is wrong", soloist.getExpertises().get(1).equals("saxophone"));
	}

	/* ATTRIBUTES	-----------------------------------------------	*/
	private Soloist soloist;

}	


