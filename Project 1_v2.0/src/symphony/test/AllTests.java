package symphony.test;

import junit.framework.*;

/**
 * JUnit test class to execute all JUNIT tests for the project
 * 
 * @author    Yu Hou
 * @version   Nov 24 2016
 */
public class AllTests extends TestCase {

	public AllTests(String name) { super(name);		}

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(Test_Composition_Soloist.suite());
		suite.addTest(Test_Composition.suite());
		suite.addTest(Test_Conductor.suite());
		suite.addTest(Test_Movement.suite());
		suite.addTest(Test_PerformedConcert.suite());
		suite.addTest(Test_ScheduledConcert.suite());
		return suite;
	}

	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	 public static void main(String[] args) {
        System.out.println("Executing AllTests ...");
        junit.textui.TestRunner.run(suite());
    }

}	/*	End of CLASS:	AllTests.java			*/
