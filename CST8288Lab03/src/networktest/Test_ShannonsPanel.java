package networktest;

import javax.swing.JLabel;

import junit.framework.*;
import network.ShannonsController;
import network.ShannonsPanel;

/**
 * JUnit tests for the ShannonsPanel class from the "network" project.
 * @author  Yu Hou
 * @version 1.0.0
 */
public class Test_ShannonsPanel extends TestCase {

	public Test_ShannonsPanel(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsPanel.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsPanel Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsPanel End");	}
	
 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
		
      System.out.println("\tExecuting Test_ShannonsPanel.testConstructors");
      
      shannonsPanel = new ShannonsPanel(controller);
	  assertNotNull("\t\tTest_ShannonsPanel.testConstructors: ShannonsPanel is not null", shannonsPanel);
	}
	
	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
      System.out.println("\tExecuting Test_ShannonsPanel.testAccessors");
      shannonsPanel = new ShannonsPanel(controller);
      assertEquals("Maximum data rate via Shannons Theorem = ???", shannonsPanel.getMaxDataRateLBL().getText());
	}
	
	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
      System.out.println("\tExecuting Test_ShannonsPanel.testMutators");
      shannonsPanel = new ShannonsPanel(controller);
      shannonsPanel.setController(controller2);
      shannonsPanel.setMaxDataRateLBL(new JLabel("test") );
      assertEquals("test", shannonsPanel.getMaxDataRateLBL().getText());
	}

	/**
	 * Test behaviors.
	 */
	public void testBehaviors() {
		System.out.println("\tExecuting Test_ShannonsPanel.testBehaviors");
		shannonsPanel = new ShannonsPanel(controller);
		
		assertTrue("Executing Test_ShannonsPanel created three panels", shannonsPanel.getComponents().length == 3);
	}
	
	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ShannonsPanel suite");
      junit.textui.TestRunner.run(suite());
  }
	
    /* ATTRIBUTES	-----------------------------------------------	*/
    private ShannonsPanel shannonsPanel = null;
    private ShannonsController controller;
    private ShannonsController controller2;
}
