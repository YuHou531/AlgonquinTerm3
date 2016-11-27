/**
 * Package for class placement
 */
package symphony.test;

import symphony.domain.Movement;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * JUnit tests for the Movement class from the "symphony" project.
 */
public class Test_Movement extends TestCase {
	/**
	 * static method to run the test suite. Extracts the test methods
	 * automatically.
	 * 
	 * @return nothing
	 */
	public static Test suite() {
		return (Test) new TestSuite(Test_Movement.class);
	}

	/**
	 * Sets up the fixture before a test is executed.
	 */
	protected void setUp() throws Exception {
		System.out.println("Test_Movement Begin");
	}

	/**
	 * Tears down the fixture after a test is executed.
	 */
	protected void tearDown() throws Exception {
		System.out.println("Test_Movement End");
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 *            integer for movement id
	 * @param name
	 *            String variable for the movement name given by composer
	 */
	public void TestConstructors() {
		System.out.println("\tExecuting Test_Movement.testConstructor");
		
		assertNull("\t\tTest_SymphonyManagement.testConstructor", movement);
		
		movement = new Movement(0, "xyz");
		
		assertNotNull("\t\tTest_SymphonyManagement.testConstructor", movement);
	}

	/**
	 * Test the accessors. To test is get the correct movement name and movement
	 * id. Test True and False.
	 */
	public void testAccessors() {
		Movement movement = new Movement(1, " Beethoven's String Quartet op. 131");

		assertFalse(movement.getID() == 2);
		assertTrue(movement.getName().equals(" Beethoven's String Quartet op. 131"));

	}
	
	/* ATTRIBUTES	-----------------------------------------------	*/
	private Movement movement;


}
