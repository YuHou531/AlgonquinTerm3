package networktest;

import javax.swing.JLabel;

import junit.framework.*;
import network.ShannonsController;
import network.ShannonsPanel;
import network.ShannonsPanel2;

/**
 * JUnit tests for the ShannonsPanel2 class from the "network" project.
 * @author  Yu Hou
 * @version 1.0.0
 */
public class Test_ShannonsPanel2 extends TestCase {

	public Test_ShannonsPanel2(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsPanel2.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsPanel2 Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsPanel2 End");	}
	
 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
		
      System.out.println("\tExecuting Test_ShannonsPanel2.testConstructors");
      
      shannonsPanel2 = new ShannonsPanel2(controller);
	  assertNotNull("\t\tTest_ShannonsPanel2.testConstructors: ShannonsPanel2 is not null", shannonsPanel2);
	}
	
	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
      System.out.println("\tExecuting Test_ShannonsPanel2.testAccessors");	
      shannonsPanel2 = new ShannonsPanel2(controller);
      assertEquals("Maximum data rate via Shannons Theorem = ???", shannonsPanel2.getMaxDataRateLBL().getText());
	}
	
	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
      System.out.println("\tExecuting Test_ShannonsPanel2.testMutators");
      shannonsPanel2 = new ShannonsPanel2(controller);
      shannonsPanel2.setController(controller2);
      shannonsPanel2.setMaxDataRateLBL(new JLabel("test") );
      assertEquals("test", shannonsPanel2.getMaxDataRateLBL().getText());
	}

	/**
	 * Test behaviors.
	 */
	public void testBehaviors() {
		System.out.println("\tExecuting Test_ShannonsPanel2.testBehaviors");
		shannonsPanel2 = new ShannonsPanel2(controller);
		
		assertTrue("Executing Test_ShannonsPanel2 created three panels", shannonsPanel2.getComponents().length == 3);
	}
	
	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ShannonsPanel2 suite");
      junit.textui.TestRunner.run(suite());
  }
	
    /* ATTRIBUTES	-----------------------------------------------	*/
    private ShannonsPanel2 shannonsPanel2 = null;
    private ShannonsController controller;
    private ShannonsController controller2;
}
