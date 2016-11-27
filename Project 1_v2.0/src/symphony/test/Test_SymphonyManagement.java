package symphony.test;

import java.time.LocalDate;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.Composition;
import symphony.domain.Composition_Soloist;
import symphony.domain.Concert;
import symphony.domain.ConcertSeason;
import symphony.domain.Conductor;
import symphony.domain.Soloist;
import symphony.domain.SymphonyManagement;

/**
 * JUnit test SymphonyManagement class from symphony.domain package
 */
public class Test_SymphonyManagement extends TestCase {

	public Test_SymphonyManagement(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_SymphonyManagement.class);		}

	protected void setUp() throws Exception { System.out.println("Test_SymphonyManagement Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_SymphonyManagement End");	}

	/**
	 * Test the constructors: null/notNull, and prove it's a Singleton class
	 */
	public void testSingletonConstructors() {
		symphony = null;//need this reset, otherwise different test methods may share the same instance
		
		System.out.println("\tExecuting Test_SymphonyManagement.testConstructors");
		assertNull("\t\tTest_SymphonyManagement.testSingletonConstructor: SymphonyManagement is null", symphony);
		symphony = SymphonyManagement.getInstance();
		assertNotNull("\t\tTest_SymphonyManagement.testSingletonConstructor: SymphonyManagement is null", symphony);
		
		//another instance of SymphonyManagement should be the same as the previous one
		SymphonyManagement symphony2 = SymphonyManagement.getInstance();
		//prove only one instance can be created
		assertTrue("\t\tTest_SymphonyManagement.testSingletonConstructor: SymphonyManagement is singleton", symphony == symphony2);	
	}
	
	
	/**
	 * test true/false of addConcert(), which will delegate the work to ConcertSeason
	 */
	public void testBehaviors(){
		symphony = null;
		
		System.out.println("\tExecuting Test_SymphonyManagement.testBehaviors");
		symphony = SymphonyManagement.getInstance();
		
		Conductor conductor = (Conductor) new Conductor.Builder("cond 1", "Herbert von Karajan").build();
		
		ConcertSeason season = new ConcertSeason(LocalDate.of(2017, 1, 1),3);
		//season.setSeasonID(0);// manually set seasonID for testing purpose
		ArrayList<Composition> compositions = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions.add(compo1);
		//compositions without soloist
		Concert cct1 = new Concert(conductor, compositions);
        //add concert successful
		assertTrue("\t\tTest_SymphonyManagement.testAddConcert()",symphony.addConcert(cct1, season));		
		
	}
	
	/**
	 * test addConcertSeason() and an overloaded addConcertSeason()
	 * This Singleton isn't thread-safe! 
	 */
    public void testMutators(){
    	symphony = null;
    	
    	System.out.println("\tExecuting Test_SymphonyManagement.testMutators");
		symphony = SymphonyManagement.getInstance();
		
		//Test add season and get season
		//if open date is before current date, addSeason should fail
		assertFalse("\t\tTest_SymphonyManagement.testAddConcertSeason", symphony.addConcertSeason(LocalDate.of(2016, 1, 1),3));
		//if open date is after current date, addSeason should succeed
		assertTrue("\t\tTest_SymphonyManagement.testAddConcertSeason", symphony.addConcertSeason(LocalDate.of(2017, 1, 1),3));
				
		//verify if add season succeed
		//ConcertSeason csx = symphony.getConcertSeason(1);//not thread-safe!!!!!Random results
		//LocalDate csxDate = csx.getOpenDate();
		//assertTrue("\t\tTest_SymphonyManagement.testAddConcertSeason", csxDate.equals(LocalDate.of(2017, 1, 1)));
		
		//Test overloaded addConcertSeason()
		ConcertSeason season = new ConcertSeason(LocalDate.of(2017, 2, 2), 5); 
		symphony.addConcertSeason(season);
		//retrieve the season just added
		int seasonID = symphony.getSeasonID(season);
		ConcertSeason seasonX = symphony.getConcertSeason(seasonID);
		assertTrue("\t\tTest_SymphonyManagement.testAddConcertSeason", seasonX.getOpenDate().equals(LocalDate.of(2017, 2, 2)));
    
    }
	
    /**
     * (1) test getSoloists(), getSeasonID(), getConcertSeason()
     * (2) getLastDatePerformed() delegates work to ConcertSeason, so it's tested over there.
     */
	public void testAccessors(){
		symphony = null;
		
		System.out.println("\tExecuting Test_SymphonyManagement.testAccessors");
		symphony = SymphonyManagement.getInstance();
		
		//create a concert having soloist
		//first create a list of soloists
		Soloist soloist1 = (Soloist) new Soloist.Builder("solo 1", "Lang Lang")
				.addPhone("123-456").addAddress("88 Bay").addExpertise("piano").build();
		ArrayList<Soloist> solos = new ArrayList<>();
		solos.add(soloist1);
		
		//create a Composition_Soloist instance, include the soloists and a composition
		Composition_Soloist compo_solo = new Composition_Soloist(solos);
		compo_solo.setComposer("Beethoven");
		compo_solo.setCompositionName("Symphony No.1");//a composition "Beethoven" with a soloist "Lang Lang" is created 
		
		//create a list of compositions
		ArrayList<Composition> compositions = new ArrayList<>();
		compositions.add(compo_solo);
		
		//create a conductor
		Conductor conductor = (Conductor) new Conductor.Builder("cond 1", "Herbert von Karajan").build();
		
		//create a concert
		Concert cct = new Concert(conductor, compositions);
		
		//add a season, and add the concert to this season
		//be careful: the open date must be different from previous seasons'. Otherwise error result.
		ConcertSeason season = new ConcertSeason(LocalDate.of(2017, 3, 3),3); 
		season.addConcert(cct);
		symphony.addConcertSeason(season);			
				
		//now get soloists in this season
		ArrayList<Soloist> solosX = symphony.getSoloists(symphony.getSeasonID(season));
		
		assertTrue("\t\tTest_SymphonyManagement.testAccessors: getSoloist", !solosX.isEmpty());
		assertTrue("\t\tTest_SymphonyManagement.testAccessors: getSoloist", solosX.contains(soloist1));

		//test getConcertSeason()
		assertTrue("\t\tTest_SymphonyManagement.testAccessors: getConcertSeason", 
		symphony.getConcertSeason(symphony.getSeasonID(season)).getOpenDate().equals(LocalDate.of(2017, 3, 3)));
		
	}
	
	/* ATTRIBUTES	-----------------------------------------------	*/
	private SymphonyManagement symphony;
}