package symphony.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * JUnit test class to execute all JUNIT tests for the Project 1.
 *
 */
public class AllTests extends TestCase {

	public AllTests(String name) { super(name);		}

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(Test_SymphonyUser.suite());
		suite.addTest(Test_AlgonquinCommonsTheatre.suite());
		suite.addTest(Test_Composition_Soloist.suite());
		suite.addTest(Test_Composition.suite());
		suite.addTest(Test_Concert.suite());
		suite.addTest(Test_ConcertSeason.suite());
		suite.addTest(Test_Conductor.suite());
		suite.addTest(Test_Movement.suite());
		suite.addTest(Test_OttawaChamberfest.suite());
		suite.addTest(Test_PerformedConcert.suite());
		suite.addTest(Test_ScheduledConcert.suite());
		suite.addTest(Test_Soloist.suite());
		suite.addTest(Test_SymphonyManagement.suite());				
		return suite;
	}



	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for stand alone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	 public static void main(String[] args) {
        System.out.println("Executing AllTests ...");
        junit.textui.TestRunner.run(suite());
    }

}	/*	End of CLASS:	AllTests.java			*/
