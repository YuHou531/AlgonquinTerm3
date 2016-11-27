package symphony.test;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.Composition;
import symphony.domain.Concert;
import symphony.domain.Conductor;
import symphony.domain.OttawaChamberfest;
import symphony.domain.ScheduledConcert;
import symphony.domain.Venue;

/**
 * JUnit tests for the ScheduledConcert class
 */
public class Test_ScheduledConcert extends TestCase {

	public Test_ScheduledConcert(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(Test_ScheduledConcert.class);
	}

	@Override
	protected void setUp() throws Exception {
		System.out.println("Test_ScheduledConcert Begin");
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("Test_ScheduledConcert End");
	}

	/**
	 * Test the constructors.
	 */
	public void testConstructors() {

		System.out.println("\tExecuting Test_ScheduledConcert.testConstructors");

		Conductor conductor1 = new Conductor.Builder("cond 1", "Herbert von Karajan").build();

		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions_1.add(compo1);
		Concert concert = new Concert(conductor1, compositions_1);

		scheduledConcert = new ScheduledConcert(concert);

		assertNotNull("\t\tTest_ScheduledConcert.testConstructors scheduledConcert is null", scheduledConcert);
	}

	/**
	 * Test the accessors, including getVenue()
	 */
	public void testAccessors() {
		System.out.println("\tExecuting Test_ScheduledConcert.testAccessors");

		Conductor conductor1 = new Conductor.Builder("cond 1", "Herbert von Karajan").build();

		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions_1.add(compo1);
		Concert concert = new Concert(conductor1, compositions_1);
		concert.setID("Concert 1");//manually set id here. In domain package tis is done automatically
		
		Venue cityHall = new OttawaChamberfest("110 Laurier");

		scheduledConcert = new ScheduledConcert(concert);
		scheduledConcert.setVenue(cityHall);
		
		//verify scheduledConcert has the same concertID as the concert
		assertTrue("\t\tTest_ScheduledConcert - test isScheduled() ", scheduledConcert.getID().equals(concert.getID()));

		//verify the concert is set to scheduled
		assertTrue("\t\tTest_ScheduledConcert - test isScheduled() ", scheduledConcert.isScheduled() == true);
		assertFalse("\t\tTest_ScheduledConcert - test isScheduled() ", scheduledConcert.isScheduled() == false);
		
		//test getVenue		
		assertTrue("\t\tTest_ScheduledConcert - test getVenue() ", (scheduledConcert.getVenue() instanceof OttawaChamberfest));
		
	}

	/**
	 * Test the mutators/modifiers: setScheduled(), setVenue()
	 */
	public void testMutators() {
		System.out.println("\tExecuting Test_ScheduledConcert.testMutators");

		Conductor conductor1 = new Conductor.Builder("cond 1", "Herbert von Karajan").build();

		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions_1.add(compo1);
		Concert concert = new Concert(conductor1, compositions_1);
		
		scheduledConcert = new ScheduledConcert(concert);

		scheduledConcert.setScheduled(false);

		assertTrue("\t\tTest_ScheduledConcert testMutators change scheduled be false ",
				scheduledConcert.isScheduled() == false);
		assertFalse("\t\tTest_ScheduledConcert testMutators change scheduled be false ",
				scheduledConcert.isScheduled() == true);

		scheduledConcert.setScheduled(true);

		assertTrue("\t\tTest_ScheduledConcert testMutators change scheduled be true ",
				scheduledConcert.isScheduled() == true);
		assertFalse("\t\tTest_ScheduledConcert testMutators change scheduled be true ",
				scheduledConcert.isScheduled() == false);
		
		//test setVenue()
		Venue cityHall = new OttawaChamberfest("101");
		scheduledConcert.setVenue(cityHall);
		assertTrue("\t\tTest_ScheduledConcert - test setVenue() ", scheduledConcert.getVenue().getAddress().equals(new String("101")));
		assertTrue("\t\tTest_ScheduledConcert - test setVenue() ", (scheduledConcert.getVenue() instanceof OttawaChamberfest));
	}

	/**
	 * Test behaviors.
	 */
	public void testBehaviors() {
		System.out.println("\tExecuting Test_ScheduledConcert.testBehaviors");

		Conductor conductor1 = new Conductor.Builder("cond 1", "Herbert von Karajan").build();

		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions_1.add(compo1);
		Concert concert = new Concert(conductor1, compositions_1);

		scheduledConcert = new ScheduledConcert(concert);
		
		scheduledConcert.setScheduled(false);

		assertTrue("\t\tTest_ScheduledConcert test change scheduled value ", scheduledConcert.isScheduled() == false);
		assertFalse("\t\tTest_ScheduledConcert test change scheduled value ", scheduledConcert.isScheduled() == true);
	}

	/* STAND-ALONE ENTRY POINT ----------------------------------------- */
	/**
	 * Main line for standalone operation.
	 * 
	 * @param args
	 *            Standard string command line parameters.
	 */
	public static void main(String[] args) {
		System.out.println("Executing Test_ScheduledConcert suite");
		junit.textui.TestRunner.run(suite());
	}

	/* ATTRIBUTES ----------------------------------------------- */
	private ScheduledConcert scheduledConcert = null;
}
