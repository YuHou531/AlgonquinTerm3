package symphony.test;

import java.util.ArrayList;

import junit.framework.*;
import symphony.domain.Composition_Soloist;
import symphony.domain.Soloist;;

/**
 * Junit test class for class Composition_Soloist
 */
public class Test_Composition_Soloist extends TestCase {

	public Test_Composition_Soloist(String name) { super(name);	}

	public static Test suite() { 
		return new TestSuite(Test_Composition_Soloist.class);		
	}

	/**
	 * set up before running each test function. 
	 */
	protected void setUp() throws Exception { 
		System.out.println("Test_Composition_Soloist Start");	
	}

	/**
	 * tear down after running each test function. 
	 */
	protected void tearDown() throws Exception {
		compoSol = null;           /* release object */
		System.out.println("Test_Composition_Soloist End");	
	}
	
	/**
 	 * Test the constructor.
 	 */
	public void testConstructors() {
		System.out.println("\tExecuting Test_Composition_Soloist.testConstructors()");
		ArrayList<Soloist> arraySol = new ArrayList<>();
		compoSol = new Composition_Soloist(arraySol);          /* create object */
		assertNotNull("\t\tcompoSol is null", compoSol);
		assertTrue("\t\tConstructor failed", compoSol.hasSoloist());
	}
	
	/**
	 * Test the accessors and mutators.
	 */
	public void testGetterandSetter() {
		System.out.println("\tExecuting Test_Composition_Soloist.testGetterandSetter()");
		
		//get solist
		ArrayList<Soloist> arraySol = new ArrayList<>();
		Soloist sol1 = new Soloist.Builder("1", "Sol1").build();
		arraySol.add(sol1);
		compoSol = new Composition_Soloist(arraySol); 
		assertNotNull("\t\tcompoSol is null", compoSol);
		assertNull("\t\tget wrong Soloist failed", compoSol.getSoloist("2"));
		assertNotNull("\t\tget Soloist failed", compoSol.getSoloist("1"));
		assertEquals("\t\tget Soloist name failed", "Sol1", compoSol.getSoloist("1").getName());
		assertEquals("\t\tget Soloists failed", arraySol, compoSol.getSoloists());
		
		//set soloist
		Soloist sol2 = new Soloist.Builder("2", "Sol2").build();
		compoSol.addSoloist(sol2);
		assertEquals("\t\tget Soloist name failed", "Sol2", compoSol.getSoloist("2").getName());
	}
	
	/**
	 * Test the behaviors.
	 */
	public void testBehaviors() {
		System.out.println("\tExecuting Test_Composition_Soloist.testBehaviors()");
		
		//delete soloist
		ArrayList<Soloist> arraySol = new ArrayList<>();
		Soloist sol1 = new Soloist.Builder("1", "Sol1").build();
		Soloist sol2 = new Soloist.Builder("2", "Sol2").build();
		arraySol.add(sol1);
		arraySol.add(sol2);
		compoSol = new Composition_Soloist(arraySol); 
		assertNotNull("\t\tcompoSol is null", compoSol);
		assertNotNull("\t\tget Soloist failed", compoSol.getSoloist("1"));
		assertNotNull("\t\tget Soloist failed", compoSol.getSoloist("2"));
		compoSol.deleteSoloist("1");
		compoSol.deleteSoloist("2");
		assertNull("\t\tget Soloist failed", compoSol.getSoloist("1"));
		assertNull("\t\tget Soloist failed", compoSol.getSoloist("2"));
	}
	
	 /**Composition_Soloist object*/
	   private Composition_Soloist compoSol = null;
}
