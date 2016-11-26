/**
 * Package for class placement
 */
package symphony.test;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.Conductor;

/**
 * JUnit tests for the Movement class from the "symphony" project.
 * 
 * @author Yun Luo, November 24, 2016
 * @version 1.0.0
 */
public class Test_Conductor extends TestCase {
	
	/**
	 * Constructor
	 * @param name String object
	 */
	public Test_Conductor(String name) { super(name);	}

	/**
	 * static method to run the test suite. Extracts the test methods
	 * automatically.
	 * 
	 * @return nothing
	 */
	public static Test suite() {
		return  (Test) new TestSuite(Test_Conductor.class);
	}

	/**
	 * Sets up the fixture before a test is executed.
	 */
	
	public void setUp() throws Exception {
		System.out.println("Test_Conductor Begin");
	}

	/**
	 * Tears down the fixture after a test is executed.
	 */
	
	public void tearDown() throws Exception {
		System.out.println("Test_Conductor End");
	}

	/**
	 * Test the builders. To get the correct address,phone number and conductor
	 * name and address Test True and False.
	 */
	
	public void testConductorBuildConstructor() {
		System.out.println("\tExecuting Test_Conductor.testBuilderConstructor");

		Conductor conductor = (Conductor) new Conductor.Builder("conductor 01", "John Smith").addPhone("999-999")
				.addAddress("77 Noname").build();

		assertNotNull("\t\tTest_Conductor.testConductorBuilder: conductor is null", conductor);

		assertTrue("\t\tTest_Conductor.testConductorBuilder: phone numbe is correct",
				conductor.getPhone().equals("999-999"));
		assertFalse("\t\tTest_Conductor.testConductorBuilder: phone numbe is incorrect",
				conductor.getPhone().equals("123-456"));

		assertTrue("\t\tTest_Conductor.testConductorBuilder: address is correct",
				conductor.getAddress().equals("77 Noname"));
		assertFalse("\t\tTest_Conductor.testConductorBuilder: address is incorrect",
				conductor.getAddress().equals("88 ebay"));

		assertTrue("\t\tTest_Soloist.testConductorBuilder: builder.constructor is ok",
				conductor.getID().equals("conductor 01") && conductor.getName().equals("John Smith"));

	}

}
