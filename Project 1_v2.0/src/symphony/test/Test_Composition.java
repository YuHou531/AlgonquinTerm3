package symphony.test;

import java.util.ArrayList;

import junit.framework.*;
import symphony.domain.Composition;
import symphony.domain.Movement;

/**
 * Junit test class for class Composition
 */
public class Test_Composition extends TestCase {
	
	public Test_Composition(String name) { super(name);	}

	public static Test suite() { 
		return new TestSuite(Test_Composition.class);		
	}

	/**
	 * set up before running each test function. 
	 */
	protected void setUp() throws Exception { 
		compo = new Composition();          /* create object */
		System.out.println("Test_Composition Start");	
	}

	/**
	 * tear down after running each test function. 
	 */
	protected void tearDown() throws Exception {
		compo = null;           /* release object */
		System.out.println("Test_Composition End");	
	}

 	/**
 	 * Test the constructor.
 	 */
	public void testConstructors() {
		System.out.println("\tExecuting Test_Composition.testConstructors()");
		assertNotNull("\t\tcompo is null", compo);
	}


	/**
	 * Test the accessors and mutators.
	 */
	public void testGetterandSetter() {
		System.out.println("\tExecuting Test_Composition.testGetterandSetter()");
      
      	assertNotNull(compo);

      	//id
      	String compoID = compo.getCompositionID();
      	int start = String.format("Composition ").length();    //according to the current format of compositionID
      	try {
			int idBefore = Integer.parseInt(compoID.substring(start));
			assertTrue("\t\tset composition id failed", idBefore > 0);
			compo = new Composition();
			compoID = compo.getCompositionID();
			int idAfter = Integer.parseInt(compoID.substring(start));
			assertEquals("\t\tget composition id failed", 1, idAfter - idBefore);
      	}
      	catch (NumberFormatException e) {
      		assertTrue("\t\texception occurs", false);
      	}
      	
      	//composition name
      	String name = "composition1";
      	compo.setCompositionName(name);
      	assertEquals("\t\tset and get composition name failed", name, compo.getCompositionName());
      	
      	//composer
      	name = "composor1";
      	compo.setComposer(name);
      	assertEquals("\t\tset and get composor failed", name, compo.getComposer());
      	
      	//has soloist
      	compo.soloistAssigned(true);
      	assertTrue("\t\tset hasSoloist failed", compo.hasSoloist());
      	compo.soloistAssigned(false);
      	assertFalse("\t\tget hasSoloist failed", compo.hasSoloist());
      	
      	//movement
      	Movement mov1 = new Movement(1, "mov1");
      	Movement mov2 = new Movement(2, "mov2");
      	compo.addMovement(mov1);
      	compo.addMovement(mov2);
      	ArrayList<Movement> arrayMovs = compo.getMovements();
      	assertEquals("\t\tget movements failed", 2, arrayMovs.size());
      	int nFound = 0;
      	for (int i = 0; i < 2; i++) {
      		if ((arrayMovs.get(i).getID() == mov1.getID() && arrayMovs.get(i).getName() == mov1.getName())
      				|| (arrayMovs.get(i).getID() == mov2.getID() && arrayMovs.get(i).getName() == mov2.getName()))
      			nFound++;
      	}
      	assertEquals("\t\tset movements failed", 2, nFound);
	}

	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_Composition suite");
      junit.textui.TestRunner.run(suite());
  }

   /**Composition object*/
   private Composition compo = null;

}
