package networktest;

import junit.framework.*;

import network.ShannonsModel;

/**
 * JUnit tests for the ShannonsModel class from the "network" project.
 * @author  Yu Hou
 * @version 1.0.0
 */
public class Test_ShannonsModel extends TestCase {
	
	public Test_ShannonsModel(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsModel.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsModel Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsModel End");	}

 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
		
      System.out.println("\tExecuting Test_ShannonsModel.testConstructors");
      
      shannonsModel = new ShannonsModel();
	  assertNotNull("\t\tTest_ShannonsModel.testConstructors: ShannonsModel is not null", shannonsModel);
	}
	
	/**
	 * Test the accessors.
	 * Sample JUnit test
	 * Given: BW = 3000 Hz SNR = 30dB; Calculate MDR ~ 29901
	 */
	public void testAccessors() {
      System.out.println("\tExecuting Test_ShannonsModel.testAccessors");
      
      shannonsModel = new ShannonsModel();
      shannonsModel.setBandwidth(3000);
      shannonsModel.setSignalToNoise(30);
      
      assertTrue("\t\tTest_ShannonsModel - test getBandwidth() ", shannonsModel.getBandwidth() == 3000);
      assertTrue("\t\tTest_ShannonsModel - test getSignalToNoise() ", shannonsModel.getSignalToNoise() == 30);
      assertTrue("\t\tTest_ShannonsModel - test maximumDataRate() ", shannonsModel.getMaximumDataRate() > 29901 && shannonsModel.getMaximumDataRate() < 29902);	
      assertFalse("\t\tTest_ShannonsModel - test getBandwidth() ", shannonsModel.getBandwidth() == 20);
      assertFalse("\t\tTest_ShannonsModel - test getSignalToNoise() ", shannonsModel.getSignalToNoise() == 10);
      assertFalse("\t\tTest_ShannonsModel - test maximumDataRate() ", shannonsModel.getMaximumDataRate() == 50);		
	}
	
	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
      System.out.println("\tExecuting Test_ShannonsModel.testMutators");
      
      shannonsModel = new ShannonsModel();
      shannonsModel.setBandwidth(30);
      shannonsModel.setSignalToNoise(5);
      
      shannonsModel.setBandwidth(60);
      shannonsModel.setSignalToNoise(40);
      assertFalse("\t\tTest_ShannonsModel - test setBandwidth() ", shannonsModel.getBandwidth() == 30);
      assertFalse("\t\tTest_ShannonsModel - test setSignalToNoise() ", shannonsModel.getSignalToNoise() == 5);
      assertTrue("\t\tTest_ShannonsModel - test setBandwidth() ", shannonsModel.getBandwidth() == 60);
      assertTrue("\t\tTest_ShannonsModel - test setSignalToNoise() ", shannonsModel.getSignalToNoise() == 40);
	}

	/**
	 * Test behaviors.
	 */
	public void testBehaviors() {
		String sMessage1 = "With a bandwidth of 0.0 hertz and \na signal-to-noise ratio of 0.0 decibels\nusing Shannon's Theorem got the Maximum data rate is 0.00 bits-per-second.";
		String sMessage2 = "hello";
		shannonsModel = new ShannonsModel();
		shannonsModel.setBandwidth(0.0);
		shannonsModel.setSignalToNoise(0.0);
		assertEquals(sMessage1, shannonsModel.toString());
		assertNotSame(sMessage2, shannonsModel.toString());
	}
	
	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ShannonsModel suite");
      junit.textui.TestRunner.run(suite());
  }
	
    /* ATTRIBUTES	-----------------------------------------------	*/
    private ShannonsModel shannonsModel = null;
}
