package symphony.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.Composition;
import symphony.domain.Concert;
import symphony.domain.Conductor;

/**
 * JUnit test Concert class from symphony.domain package 
 */
public class Test_Concert extends TestCase {
	
	public Test_Concert(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_Concert.class);		}

	protected void setUp() throws Exception { System.out.println("Test_Concert Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_Concert End");	}

	/**
	 * Test Constructor with arguments
	 */
	public void testConstructor() {
		
		System.out.println("\tExecuting Test_Concert.testConstructor");
		
		assertNull("\t\tTest_Concert.testConstructor", concert);
		
		//set conductor
		Conductor conductor = (Conductor) new Conductor.Builder("cond 3", "seiji Ozawa")
				.addAddress("Tokyo").build();
		
		//set compositions
		ArrayList<Composition> compositions = new ArrayList<>();
		Composition compo = new Composition();
		compo.setComposer("Bach");
		compo.setCompositionName("BWV 1");
		compositions.add(compo);
		
		//create concert
		concert = new Concert(conductor, compositions);
		
		assertNotNull("\t\tTest_Concert.testConstructor", concert);
	}
	
	/**
	 * test isScheduled(), isPerformed()
	 */
    public void testBehaviors() {
		
		System.out.println("\tExecuting Test_Concert.testBehaviors");
		
		//set conductor
		Conductor conductor = (Conductor) new Conductor.Builder("cond 3", "seiji Ozawa")
						.addAddress("Tokyo").build();
				
		//set compositions
		ArrayList<Composition> compositions = new ArrayList<>();
		Composition compo = new Composition();
		compo.setComposer("Bach");
		compo.setCompositionName("BWV 1");
		compositions.add(compo);
		
		//create concert
		concert = new Concert(conductor, compositions);		
		
		assertFalse("\t\tTest_Concert.testBehaviors", concert.isScheduled());
		assertFalse("\t\tTest_Concert.testBehaviors", concert.isPerformed());
	}
    
    /**
     * test setID(), setDate, setTime(), setScheduled(), setPerformed(), setConductor(), setCompositions()
     */
    public void testMutators() {
		
		System.out.println("\tExecuting Test_Concert.testMutators");

		//set conductor
		Conductor conductor = (Conductor) new Conductor.Builder("cond 3", "seiji Ozawa")
						.addAddress("Tokyo").build();
		
		//set compositions
		ArrayList<Composition> compositions = new ArrayList<>();
		Composition compo = new Composition();
		compo.setComposer("Bach");
		compo.setCompositionName("BWV 1");
		compositions.add(compo);
		
		//create concert
		concert = new Concert(conductor, compositions);
		
		//setDate
		concert.setDate(LocalDate.of(2016, 12, 25));
		assertTrue("\t\tTest_Concert.testMutators", concert.getDate().equals(LocalDate.of(2016, 12, 25)));
		
		//setTime
		concert.setTime(LocalTime.of(10, 30));
		assertTrue("\t\tTest_Concert.testMutators", concert.getTime().getHour() == 10);
		assertTrue("\t\tTest_Concert.testMutators", concert.getTime().getMinute() == 30);
		
		//setScheduled
		concert.setScheduled(true);
		assertTrue("\t\tTest_Concert.testMutators", concert.isScheduled());
		
		//setPerformed
		concert.setPerformed(false);
		assertFalse("\t\tTest_Concert.testMutators", concert.isPerformed());
		
		//setID
		concert.setID("Concert 1");
		assertTrue("\t\tTest_Concert.testMutators", concert.getID().equals("Concert 1"));
		
		concert.setPerformed(true);//now concert is already performed
		concert.setID("Concert 2");//should not be allowed to change id
		assertFalse("\t\tTest_Concert.testMutators", concert.getID().equals("Concert 2"));
		
		//setConductor
		Conductor conductor2 = (Conductor) new Conductor.Builder("cond 2", "Alan Gilbert")
				.addPhone("613-777-4444").addAddress("ottawa").build();
		concert.setConductor(conductor2);
		assertFalse("\t\tTest_Concert.testMutators", concert.getConductor().getName().equals("Seiji Ozawa"));
		assertTrue("\t\tTest_Concert.testMutators", concert.getConductor().getName().equals("Alan Gilbert"));

		//setCompositions
		ArrayList<Composition> compositions2 = new ArrayList<>();
		Composition compo2 = new Composition();
		compo2.setComposer("Mozart");
		compo2.setCompositionName("Piano Concerto No.5");
		compositions2.add(compo2);
		
		concert.setCompositions(compositions2);
		assertFalse("\t\tTest_Concert.testMutators", concert.getCompositions().get(0).getComposer().equals("Bach"));
		assertTrue("\t\tTest_Concert.testMutators", concert.getCompositions().get(0).getComposer().equals("Mozart"));
		
	}
    
    /**
     * test getID(), getDate(), getTime(), getConductor(), getCompositions()
     */
    public void testAccessors() {
		
		System.out.println("\tExecuting Test_Concert.testAccessors");
		

		//set conductor
		Conductor conductor = (Conductor) new Conductor.Builder("cond 3", "seiji Ozawa")
						.addAddress("Tokyo").build();
		
		//set compositions
		ArrayList<Composition> compositions = new ArrayList<>();
		Composition compo = new Composition();
		compo.setComposer("Bach");
		compo.setCompositionName("BWV 1");
		compositions.add(compo);
		
		//create concert
		concert = new Concert(conductor, compositions);
		
		//getDate
		concert.setDate(LocalDate.of(2016, 12, 25));
		assertTrue("\t\tTest_Concert.testAccessors", concert.getDate().equals(LocalDate.of(2016, 12, 25)));
		
		//getTime
		concert.setTime(LocalTime.of(10, 30));
		assertTrue("\t\tTest_Concert.testAccessors", concert.getTime().getHour() == 10);
		assertTrue("\t\tTest_Concert.testAccessors", concert.getTime().getMinute() == 30);
		
		//getID
		concert.setID("Concert 1");
		assertTrue("\t\tTest_Concert.testAccessors", concert.getID().equals("Concert 1"));

		//getConductor
		assertTrue("\t\tTest_Concert.testAccessors", concert.getConductor().getName().equals("seiji Ozawa"));

		//getCompositions
		assertTrue("\t\tTest_Concert.testAccessors", concert.getCompositions().get(0).getComposer().equals("Bach"));
		
	}

	/* ATTRIBUTES	-----------------------------------------------	*/
	private Concert concert;

}	


