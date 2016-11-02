package networktest;

import javax.swing.JLabel;

import junit.framework.*;
import network.ShannonsController;
import network.ShannonsPanel;
import network.ShannonsPanel2;
import network.ShannonsPanel3;

/**
 * JUnit tests for the ShannonsPanel3 class from the "network" project.
 * @author  Yu Hou
 * @version 1.0.0
 */
public class Test_ShannonsPanel3 extends TestCase {

	public Test_ShannonsPanel3(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsPanel3.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsPanel3 Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsPanel3 End");	}
	
 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
		
      System.out.println("\tExecuting Test_ShannonsPanel3.testConstructors");
      
      shannonsPanel3 = new ShannonsPanel3(controller);
	  assertNotNull("\t\tTest_ShannonsPanel3.testConstructors: ShannonsPanel2 is not null", shannonsPanel3);
	}
	
	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
      System.out.println("\tExecuting Test_ShannonsPanel3.testAccessors");
      shannonsPanel3 = new ShannonsPanel3(controller);
      shannonsPanel3.initGUI();
      assertEquals("Maximum data rate via Shannons Theorem = ???", shannonsPanel3.getMaxDataRateLBL().getText());
	}
	
	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
      System.out.println("\tExecuting Test_ShannonsPanel3.testMutators");
      shannonsPanel3 = new ShannonsPanel3(controller);
      shannonsPanel3.setController(controller2);
      shannonsPanel3.setMaxDataRateLBL(new JLabel("test") );
      assertEquals("test", shannonsPanel3.getMaxDataRateLBL().getText());
	}

	/**
	 * Test behaviors.
	 */
	public void testBehaviors() {
		System.out.println("\tExecuting Test_ShannonsPanel3.testBehaviors");
		shannonsPanel3 = new ShannonsPanel3(controller);
		assertNotNull("\t\tTest_ShannonsPanel3.createBandwidthPanel is not null", shannonsPanel3.createBandwidthPanel());
		assertNotNull("\t\tTest_ShannonsPanel3.createBandwidthPanel is not null", shannonsPanel3.createSignalToNoisePanel());
	}
	
	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ShannonsPanel3 suite");
      junit.textui.TestRunner.run(suite());
  }
	
    /* ATTRIBUTES	-----------------------------------------------	*/
    private ShannonsPanel3 shannonsPanel3 = null;
    private ShannonsController controller;
    private ShannonsController controller2;
}
