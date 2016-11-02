package networktest;

import junit.framework.*;

import network.ShannonsModel;
import network.ShannonsTheorem;

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
		ShannonsModel model = shannonsTheorem.getModel();
		model.addObserver(shannonsTheorem.panel1);
		shannonsTheorem.panel1.bandwidthTextField.setText("3000");
		shannonsTheorem.panel1.stnTextField.setText("20");
		
		assertNotNull("\t\tTest_ShannonsController.testBehaviors controller / model  is not null", model);
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
}
