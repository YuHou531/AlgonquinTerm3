package symphony.test;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.Composition;
import symphony.domain.Concert;
import symphony.domain.Conductor;
import symphony.domain.PerformedConcert;

/**
 * JUnit tests for the PerformedConcert class
 * 
 */
public class Test_PerformedConcert extends TestCase {

	public Test_PerformedConcert(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(Test_PerformedConcert.class);
	}

	@Override
	protected void setUp() throws Exception {
		System.out.println("Test_PerformedConcert Begin");
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("Test_PerformedConcert End");
	}

	/**
	 * Test the constructors.
	 */
	public void testConstructors() {

		System.out.println("\tExecuting Test_PerformedConcert.testConstructors");

		Conductor conductor1 = new Conductor.Builder("cond 1", "Herbert von Karajan").build();

		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions_1.add(compo1);
		Concert concert = new Concert(conductor1, compositions_1);

		performedConcert = new PerformedConcert(concert);

		assertNotNull("\t\tTest_PerformedConcert.testConstructors performedConcert is null", performedConcert);
	}

	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
		System.out.println("\tExecuting Test_PerformedConcert.testAccessors");

		Conductor conductor1 = new Conductor.Builder("cond 1", "Herbert von Karajan").build();

		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions_1.add(compo1);
		Concert concert = new Concert(conductor1, compositions_1);

		performedConcert = new PerformedConcert(concert);

		assertTrue("\t\tTest_PerformedConcert - test isPerformed() ", performedConcert.isPerformed() == true);
		assertFalse("\t\tTest_PerformedConcert - test isPerformed() ", performedConcert.isPerformed() == false);
	}

	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
		System.out.println("\tExecuting Test_PerformedConcert.testMutators");

		Conductor conductor1 = new Conductor.Builder("cond 1", "Herbert von Karajan").build();

		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions_1.add(compo1);
		Concert concert = new Concert(conductor1, compositions_1);

		performedConcert = new PerformedConcert(concert);

		performedConcert.setPerformed(false);

		assertTrue("\t\tTest_PerformedConcert testMutators change performed be false ",
				performedConcert.isPerformed() == false);
		assertFalse("\t\tTest_PerformedConcer testMutators change performed be false ",
				performedConcert.isPerformed() == true);

		performedConcert.setPerformed(true);

		assertTrue("\t\tTest_PerformedConcert testMutators change performed be true ",
				performedConcert.isPerformed() == true);
		assertFalse("\t\tTest_PerformedConcer testMutators change performed be true ",
				performedConcert.isPerformed() == false);

	}

	/**
	 * Test behaviors: if a concert is set to performed, then it must have also been scheduled
	 */
	public void testBehaviors() {
		System.out.println("\tExecuting Test_PerformedConcert.testBehaviors");

		Conductor conductor1 = new Conductor.Builder("cond 1", "Herbert von Karajan").build();

		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions_1.add(compo1);
		Concert concert = new Concert(conductor1, compositions_1);

		performedConcert = new PerformedConcert(concert);
		
		//if a concert is set to performed, then it must have also been scheduled
		assertTrue("\t\tTest_PerformedConcert", performedConcert.isScheduled() == true);

	}

	/* STAND-ALONE ENTRY POINT ----------------------------------------- */
	/**
	 * Main line for standalone operation.
	 * 
	 * @param args
	 *            Standard string command line parameters.
	 */
	public static void main(String[] args) {
		System.out.println("Executing Test_PerformedConcert suite");
		junit.textui.TestRunner.run(suite());
	}

	/* ATTRIBUTES ----------------------------------------------- */
	private PerformedConcert performedConcert = null;
}