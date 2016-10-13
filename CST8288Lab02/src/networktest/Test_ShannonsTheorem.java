/*
 *  @(#)Test_ShannonsTheorem.java	Feb 17, 2005
 *
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warrantee of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 *
 */

package networktest;

import junit.framework.*;

import network.ShannonsTheorem;

/**
 *	JUnit tests for the ShannonsTheorem class from the "network" project.
 * @author  Yu Hou
 * @version 1.0.0
 */
public class Test_ShannonsTheorem extends TestCase {

	public Test_ShannonsTheorem(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsTheorem.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsTheorem Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsTheorem End");	}

 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
		
      System.out.println("\tExecuting Test_ShannonsTheorem.testConstructors");
      
      shannonsTheorem = new ShannonsTheorem();
	  assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is not null", shannonsTheorem);
		
      shannonsTheorem = new ShannonsTheorem(10, 20);
	  assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is not null", shannonsTheorem);
	}
	
	/**
	 * Test the accessors.
	 * Sample JUnit test
	 * Given: BW = 3000 Hz SNR = 30dB; Calculate MDR ~ 29901
	 */
	public void testAccessors() {
      System.out.println("\tExecuting Test_ShannonsTheorem.testAccessors");
      
      shannonsTheorem = new ShannonsTheorem(3000, 30);
      
      assertTrue("\t\tTest_ShannonsTheorem - test getBandwidth() ", shannonsTheorem.getBandwidth() == 3000);
      assertTrue("\t\tTest_ShannonsTheorem - test getSignalToNoise() ", shannonsTheorem.getSignalToNoise() == 30);
      assertTrue("\t\tTest_ShannonsTheorem - test getMaximumDataRate() ", shannonsTheorem.getMaximumDataRate() > 29901 && shannonsTheorem.getMaximumDataRate() < 29902);	
      assertFalse("\t\tTest_ShannonsTheorem - test getBandwidth() ", shannonsTheorem.getBandwidth() == 20);
      assertFalse("\t\tTest_ShannonsTheorem - test getSignalToNoise() ", shannonsTheorem.getSignalToNoise() == 10);
      assertFalse("\t\tTest_ShannonsTheorem - test getMaximumDataRate() ", shannonsTheorem.getMaximumDataRate() == 50);		
	}

	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
      System.out.println("\tExecuting Test_ShannonsTheorem.testMutators");
      
      shannonsTheorem = new ShannonsTheorem(30, 5);
      shannonsTheorem.setBandwidth(60);
      shannonsTheorem.setSignalToNoise(40);
      assertFalse("\t\tTest_ShannonsTheorem - test setBandwidth() ", shannonsTheorem.getBandwidth() == 30);
      assertFalse("\t\tTest_ShannonsTheorem - test setSignalToNoise() ", shannonsTheorem.getSignalToNoise() == 5);
      assertTrue("\t\tTest_ShannonsTheorem - test setBandwidth() ", shannonsTheorem.getBandwidth() == 60);
      assertTrue("\t\tTest_ShannonsTheorem - test setSignalToNoise() ", shannonsTheorem.getSignalToNoise() == 40);
	}

	/**
	 * Test behaviors.
	 */
	public void testToString() {
		String sMessage1 = "With a bandwidth of 0.0 hertz and \na signal-to-noise ratio of 0.0 decibels\nusing Shannon's Theorem got the Maximum data rate is 0.00 bits-per-second.";
		String sMessage2 = "hello";
		shannonsTheorem = new ShannonsTheorem(0.0, 0.0);
		assertEquals(sMessage1, shannonsTheorem.toString());
		assertNotSame(sMessage2, shannonsTheorem.toString());
	}

	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ShannonsTheorem suite");
      junit.textui.TestRunner.run(suite());
  }

   /* ATTRIBUTES	-----------------------------------------------	*/
   private ShannonsTheorem shannonsTheorem = null;
   
}	/*	End of CLASS:	Test_ShannonsTheorem.java				*/
