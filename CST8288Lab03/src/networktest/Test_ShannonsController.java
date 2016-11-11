package networktest;

import java.util.Observer;

import junit.framework.*;

import network.*;

/**
 * JUnit tests for the ShannonsController class from the "network" project.
 * @author  Yu Hou
 * @version 1.0.0
 */
public class Test_ShannonsController extends TestCase {
	
	public Test_ShannonsController(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsController.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsController Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsController End");	}

	/**
	 * Test behaviors.
	 */
	public void testBehaviors() {
		System.out.println("\tExecuting Test_ShannonsController.testBehaviors");
		shannonsTheorem = new ShannonsTheorem();
		shannonsController = new ShannonsController() {
			@Override
			public void setSignalToNoise(double signalToNoiseRatio) {
				shannonsTheorem.setSignalToNoise(signalToNoiseRatio);
			}
			
			@Override
			public void setBandwidth(double bandwidth) {
				shannonsTheorem.setBandwidth(bandwidth);
			}
			
			@Override
			public void addObserver(Observer o) {
				shannonsTheorem.addObserver(o);	
			}
		};
		shannonsController.setBandwidth(1000);
		shannonsController.setSignalToNoise(50);

	    assertTrue("\t\tTest_ShannonsController.testBehaviors ", shannonsTheorem.getBandwidth() == 1000);
	    assertTrue("\t\tTest_ShannonsController.testBehaviors ", shannonsTheorem.getSignalToNoise() == 50);
	    assertFalse("\t\tTest_ShannonsController.testBehaviors ", shannonsTheorem.getBandwidth() == 300);
	    assertFalse("\t\tTest_ShannonsController.testBehaviors ", shannonsTheorem.getSignalToNoise() == 100);
	}
	
	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ShannonsController suite");
      junit.textui.TestRunner.run(suite());
  	}
	
    /* ATTRIBUTES	-----------------------------------------------	*/
    private ShannonsTheorem shannonsTheorem = null;
    private ShannonsController shannonsController = null;
}
