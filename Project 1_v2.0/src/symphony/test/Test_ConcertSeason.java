package symphony.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.AlgonquinCommonsTheatre;
import symphony.domain.Composition;
import symphony.domain.Composition_Soloist;
import symphony.domain.Concert;
import symphony.domain.ConcertSeason;
import symphony.domain.Conductor;
import symphony.domain.OttawaChamberfest;
import symphony.domain.Soloist;
import symphony.domain.Venue;

/**
 * test ConcertSeason in symphony.test package
 */
public class Test_ConcertSeason extends TestCase {
	
	public Test_ConcertSeason(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ConcertSeason.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ConcertSeason Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ConcertSeason End");	}

	/**
	 * Test Constructor with arguments
	 */
	public void testConstructor() {
		
		System.out.println("\tExecuting Test_ConcertSeason.testConstructor");
		
		assertNull("\t\tTest_ConcertSeason.testConstructor", season);
		
		LocalDate openDate = LocalDate.of(2017, 1, 1);
		int length = 30;
		season = new ConcertSeason(openDate, length);

		assertNotNull("\t\tTest_ConcertSeason.testConstructor", season);
	}
    
    /**
     * test addConcert(), setSeasonID(), setOpenDate(), setLength(),
     * scheduleConcert(), setPerformedDate()
     */
    public void testMutators() {
		
		System.out.println("\tExecuting Test_ConcertSeason.testMutators");

		LocalDate openDate = LocalDate.of(2017, 1, 1);
		int length = 30;
		season = new ConcertSeason(openDate, length);
		
		//addConcert
		Conductor conductor = (Conductor) new Conductor.Builder("cond 3", "seiji Ozawa")
						.addAddress("Tokyo").build();
		ArrayList<Composition> compositions = new ArrayList<>();
		Composition compo = new Composition();
		compo.setComposer("Bach");
		compo.setCompositionName("BWV 1");
		compositions.add(compo);
		Concert concert = new Concert(conductor, compositions);
		//the first concert added, its ID is automatically assigned to "Concert 1"
		//but the concertID can also be manually set later. 
		//Here don't use auto-increment in test.
		season.addConcert(concert);
		concert.setID("Concert 1");//manually set concert ID must be after addConcert, otherwise it will be overwritten by auto-increment
		
		assertNotNull("\t\tTest_ConcertSeason.testMutators", season.getConcert(concert));
		
		//setOpenDate
		season.setOpenDate(LocalDate.of(2016, 12, 25));
		assertFalse("\t\tTest_ConcertSeason.testMutators", season.getOpenDate().equals(LocalDate.of(2017, 1, 1)));
		assertTrue("\t\tTest_ConcertSeason.testMutators", season.getOpenDate().equals(LocalDate.of(2016, 12, 25)));
		
		//setLength
		season.setLength(5);
		assertFalse("\t\tTest_ConcertSeason.testMutators", season.getLength() == 30);
		assertTrue("\t\tTest_ConcertSeason.testMutators", season.getLength() == 5);
		
		//setSeasonID
		season.setSeasonID(4);//in domain package, seasonID is auto-incremented
		assertTrue("\t\tTest_ConcertSeason.testMutators", season.getSeasonID() == 4);
		
		//scheduleConcert: 
		//a concert's scheduled date must be between season's open date and end date
		//first scheduled date is after the season's end date -> should fail
		LocalDate overDate = LocalDate.of(2017, 1, 5);
		LocalTime scheduledTime = LocalTime.of(10, 20);
		Venue algonquin = new AlgonquinCommonsTheatre("1385");

		assertFalse("\t\tTest_ConcertSeason.testMutators", season.scheduleConcert("Concert 1", overDate, scheduledTime, algonquin));
		
		//second scheduled date is before the season's open date -> should fail
		LocalDate preDate = LocalDate.of(2016, 12, 20);
		assertFalse("\t\tTest_ConcertSeason.testMutators", season.scheduleConcert("Concert 1", preDate, scheduledTime, algonquin));
		
		//third scheduled date is within the season period -> should succeed
		LocalDate scheduledDate = season.getOpenDate();
		assertTrue("\t\tTest_ConcertSeason.testMutators", season.scheduleConcert("Concert 1", scheduledDate, scheduledTime, algonquin));
		
		//setPerformedDate
		//same as scheduled date, performed date must be within season's period
		LocalDate performedDate = scheduledDate;
		assertTrue("\t\tTest_ConcertSeason.testMutators", season.setPerformedDate("Concert 1", performedDate, scheduledTime));
		
	}
    
    /**
     * test getSeasonID(), getOpenDate(), getLength(), getConcerts(), 
     * two overloaded getConcert() methods
     * getPerformedConcerts()
     */
    public void testAccessors() {
		
		System.out.println("\tExecuting Test_ConcertSeason.testAccessors");
		
		LocalDate openDate = LocalDate.of(2017, 7, 1);
		int length = 30;
		season = new ConcertSeason(openDate, length);
		season.setSeasonID(1);
		
		//test getSeasonID():
		assertTrue("\t\tTest_ConcertSeason.testAccessors", season.getSeasonID() == 1);
		
		//test getOpenDate
		assertTrue("\t\tTest_ConcertSeason.testAccessors", season.getOpenDate().equals(openDate));
		
		//test getLength
		assertTrue("\t\tTest_ConcertSeason.testAccessors", season.getLength() == length); 
		
		//Now, add a concert
		Conductor conductor = (Conductor) new Conductor.Builder("cond 3", "seiji Ozawa")
						.addAddress("Tokyo").build();
		ArrayList<Composition> compositions = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		compositions.add(compo1);
		Composition compo2 = new Composition();
		compo2.setComposer("Beethoven");
		compo2.setCompositionName("Symphony No.1");
		compositions.add(compo2);
		Concert concert = new Concert(conductor, compositions);		
		
		season.addConcert(concert);
		concert.setID("Concert 2");//manually set concert ID must be after addConcert, otherwise it will be overwritten by auto-increment
		
		//test getConcert
		assertNotNull("\t\tTest_ConcertSeason.testAccessors", season.getConcert(concert));
		
		//test getConcerts
		assertTrue("\t\tTest_ConcertSeason.testAccessors", 
				season.getConcerts().get(0).getConductor().getName().equals("seiji Ozawa"));
		assertTrue("\t\tTest_ConcertSeason.testAccessors", 
				season.getConcerts().get(0).getCompositions().get(0).getComposer().equals("Bach"));
		
		//test getPerformedConcert
		//first, no concert is performed, so nothing is returned
		assertTrue("\t\tTest_ConcertSeason.testAccessors", season.getPerformedConcerts().isEmpty());
		
		//now, set a concert as performed, then get it
		//now first schedule then set performed
		//if first set a performed date -> should fail because need firstly scheduled (
		//otherwise throw a NullPointException
		LocalDate scheduledDate = season.getOpenDate();
		LocalTime scheduledTime = LocalTime.of(6, 0);
		Venue algonquin = new AlgonquinCommonsTheatre("1385");
		season.scheduleConcert("Concert 2", scheduledDate, scheduledTime, algonquin);
		season.setPerformedDate("Concert 2", scheduledDate, scheduledTime);
		
		assertFalse("\t\tTest_ConcertSeason.testAccessors", season.getPerformedConcerts().isEmpty());
		
		assertTrue("\t\tTest_ConcertSeason.testAccessors", 
				season.getPerformedConcerts().get(0).isPerformed());
		
		assertTrue("\t\tTest_ConcertSeason.testAccessors", 
				season.getPerformedConcerts().get(0).getID().equals("Concert 2"));
		
	}
    
    /**
	 * test getLastDatePerformed()
	 */
    public void testBehaviors() {
		
		System.out.println("\tExecuting Test_ConcertSeason.testBehaviors");
		
		season = new ConcertSeason(LocalDate.of(2017, 1, 1), 10);
		
		//test get the last date a soloist performed a given composition
		//first populate a list of soloists, list of compositions with soloists 
		//(for simplicity, no compositions without soloist here)

		Soloist soloist1 = (Soloist) new Soloist.Builder("solo 1", "Lang Lang")
				.addPhone("123-456").addExpertise("piano").addExpertise("drum").build();
		Soloist soloist2 = (Soloist) new Soloist.Builder("solo 2", "Marc-André Hamelin")
				.addExpertise("piano").addExpertise("saxophone").build();
		
		//add two concerts, at least one is performed, so can get the performed date
		//build concert 1
		ArrayList<Composition> compositions_1 = new ArrayList<>();
		ArrayList<Composition_Soloist> compo_solos_1 = new ArrayList<>();
		ArrayList<Soloist> subSolos_1 = new ArrayList<>();
		subSolos_1.add(soloist1);
		Composition_Soloist compo_solo_1 = new Composition_Soloist(subSolos_1);
		compo_solo_1.setComposer("Mozart");
		compo_solo_1.setCompositionName("Piano Concerto No.5");
		compo_solos_1.add(compo_solo_1);
		compositions_1.addAll(compo_solos_1);
		
		Conductor conductor = (Conductor) new Conductor.Builder("cond 1", "Herbert von Karajan")
		.addPhone("789-012").build();
		
		Concert concert_1 = new Concert(conductor, compositions_1);
		
		//build concert 2
		ArrayList<Composition> compositions_2 = new ArrayList<>();
		ArrayList<Composition_Soloist> compo_solos_2 = new ArrayList<>();
		ArrayList<Soloist> subSolos_2 = new ArrayList<>();
		subSolos_2.add(soloist1);
		subSolos_2.add(soloist2);
		Composition_Soloist compo_solo_2 = new Composition_Soloist(subSolos_2);
		compo_solo_2.setComposer("Beethoven");
		compo_solo_2.setCompositionName("Symphony No.1");
		compo_solos_2.add(compo_solo_2);
		compositions_2.addAll(compo_solos_2);
		
		Concert concert_2 = new Concert(conductor, compositions_2);
		
		//add two concerts to season
		season.addConcert(concert_1);//concert id is auto assigned "Concert 1"
		season.addConcert(concert_2);//concert id is auto assigned "Concert 2"
		
		//now schedule both concerts
		//schedule concert 1
		LocalDate scheduledDate = season.getOpenDate();
		LocalTime scheduledTime = LocalTime.of(10, 30);//time 10:30
		Venue algonquin = new AlgonquinCommonsTheatre("1385 Woodroffe Ave");
		season.scheduleConcert(concert_1.getID(), scheduledDate, scheduledTime, algonquin);
		
		//schedule concert 2
		scheduledDate = season.getOpenDate().plusDays(season.getLength()-1);
		scheduledTime = LocalTime.of(6, 0);//time 6:00
		Venue cityHall = new OttawaChamberfest("110 Laurier Ave W");
		season.scheduleConcert(concert_2.getID(), scheduledDate, scheduledTime, cityHall);
		
		//set concert 1 as performed: performed date/time are the same as scheduled date/time
		season.setPerformedDate(concert_1.getID(), season.getOpenDate(), LocalTime.of(10, 30));
		
		//now find the last date soloist1 performed a composition
		Composition composition = compo_solo_1;
		//the last date soloist1 performed "Mozart""Piano Concerto No.5" -> should be open date
		LocalDate lastDate = season.getLastDatePerformed(soloist1, composition);
		assertTrue("\t\tTest_ConcertSeason.testBehaviors", lastDate.equals(season.getOpenDate()));
		
		//the last date soloist1 performed "Beethoven""Symphony No.1" -> should return null
		composition = compo_solo_2;
		lastDate = season.getLastDatePerformed(soloist1, composition);
		assertNull("\t\tTest_ConcertSeason.testBehaviors", lastDate);

	}

	/* ATTRIBUTES	-----------------------------------------------	*/
	private ConcertSeason season;

}	


