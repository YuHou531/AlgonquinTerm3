package symphony.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import symphony.domain.AlgonquinCommonsTheatre;
import symphony.domain.ApplicationController;
import symphony.domain.Composition;
import symphony.domain.Composition_Soloist;
import symphony.domain.Concert;
import symphony.domain.ConcertSeason;
import symphony.domain.Conductor;
import symphony.domain.OttawaChamberfest;
import symphony.domain.Soloist;
import symphony.domain.SymphonyManagement;
import symphony.domain.SymphonyUser;
import symphony.domain.Venue;

/**
 * JUnit test SymphonyUser class from Symphony.domain package
 */
public class Test_SymphonyUser extends TestCase {

	public Test_SymphonyUser(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_SymphonyUser.class);		}

	protected void setUp() throws Exception { System.out.println("Test_SymphonyUser Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_SymphonyUser End");	}

	/**
	 * Test the constructors.
	 */
	public void testConstructors() {

		System.out.println("\tExecuting Test_SymphonyUser.testConstructors");
		
		assertNull("\t\tTest_SymphonyManagement.testConstructor: Symphony user is null", user);
		
		ApplicationController symphony = SymphonyManagement.getInstance();
		SymphonyUser user = new SymphonyUser(symphony);
	
		assertNotNull("\t\tTest_SymphonyManagement.testConstructor: Symphony user is null", user);
		
	}
    
	/**
	 * test methods:
	 * addConcert(), addConcertSeason(), getConcertSeason(), getSoloists(), getlastDatePerformed()
	 */
	public void testBahaviors(){
		System.out.println("\tExecuting Test_SymphonyUser.testBehaviors");

		SymphonyUser user = new SymphonyUser(SymphonyManagement.getInstance());
		
		// add a concert
		//first populate conductor list and soloist list
		ArrayList<Soloist> soloists = new ArrayList<>();
		Soloist soloist1 = (Soloist) new Soloist.Builder("solo 1", "Lang Lang")
				.addPhone("123-456").addExpertise("piano").addExpertise("drum").build();
		Soloist soloist2 = (Soloist) new Soloist.Builder("solo 2", "Marc-André Hamelin")
				.addExpertise("piano").addExpertise("saxophone").build();
		Soloist soloist3 = (Soloist) new Soloist.Builder("solo 3", "Glenn Gould")
				.addExpertise("cello").addPhone("413-000-1111").build();
		Soloist soloist4 = (Soloist) new Soloist.Builder("solo 4", "Itzhak Perlman")
				.addAddress("Isreal").addExpertise("violin").build();
		soloists.add(soloist1);
		soloists.add(soloist2);
		soloists.add(soloist3);
		soloists.add(soloist4);
		
		ArrayList<Conductor> conductors = new ArrayList<>();
		Conductor conductor1 = (Conductor) new Conductor.Builder("cond 1", "Herbert von Karajan")
				.addPhone("789-012").build();
		Conductor conductor2 = (Conductor) new Conductor.Builder("cond 2", "Alan Gilbert")
				.addPhone("613-777-4444").addAddress("ottawa").build();
		Conductor conductor3 = (Conductor) new Conductor.Builder("cond 3", "seiji Ozawa")
				.addAddress("Tokyo").build();
		conductors.add(conductor1);
		conductors.add(conductor2);
		conductors.add(conductor3);
		
		//test: add concert seasons
		user.addConcertSeason(LocalDate.of(2017, 5, 1), 30);
		user.addConcertSeason(LocalDate.of(2017, 7, 15), 10);			
		ConcertSeason season1 = user.getConcertSeasons().get(0);
		
		//verify add/get concert season
		assertTrue("\t\tTest_SymphonyManagement.testBehaviors", season1.getOpenDate().equals(LocalDate.of(2017, 5, 1)));
		assertFalse("\t\tTest_SymphonyManagement.testBehaviors", season1.getOpenDate().equals(LocalDate.of(2017, 7, 15)));
		
		Conductor cond1 = conductors.get(0);

		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		Composition compo2 = new Composition();
		compo2.setComposer("Beethoven");
		compo2.setCompositionName("Symphony No.1");
		compositions_1.add(compo1);
		compositions_1.add(compo2);

		ArrayList<Composition_Soloist> compo_solos_1 = new ArrayList<>();
		ArrayList<Soloist> subSolos_1 = new ArrayList<>();
		subSolos_1.add(soloists.get(0));
		Composition_Soloist compo_solo_1 = new Composition_Soloist(subSolos_1);
		compo_solo_1.setComposer("Mozart");
		compo_solo_1.setCompositionName("Piano Concerto No.5");
		compo_solos_1.add(compo_solo_1);

		compositions_1.addAll(compo_solos_1);
		//create a concert, add the concert
		Concert concert_1 = new Concert(cond1, compositions_1);
		user.addConcert(concert_1, season1);

		//add another concert -------------------------------------------------------------
		Conductor cond2 = conductors.get(2);

		ArrayList<Composition> compositions_2 = new ArrayList<>();
		Composition compo3 = new Composition();
		compo3.setComposer("Mozart");
		compo3.setCompositionName("Violin Concerto No.1");
		compositions_2.add(compo3);

		ArrayList<Composition_Soloist> compo_solos_2 = new ArrayList<>();
		ArrayList<Soloist> subSolos_2 = new ArrayList<>();
		subSolos_2.add(soloists.get(0));
		subSolos_2.add(soloists.get(2));
		Composition_Soloist compo_solo_2 = new Composition_Soloist(subSolos_2);
		compo_solo_2.setComposer("Beethoven");
		compo_solo_2.setCompositionName("Piano Concerto No.0");
		compo_solos_2.add(compo_solo_2);

		compositions_2.addAll(compo_solos_2);
		
		//create the second concert, add the concert
		Concert concert_2 = new Concert(cond2, compositions_2);
		user.addConcert(concert_2, season1);

		//schedule concert_1 ---------------------------------------------------------
		//scheduled date must NOT be before open date of the season
		LocalDate scheduledDate = LocalDate.of(2017, 5, 2);
		LocalTime scheduledTime = LocalTime.of(10, 30);//time 10:30
		Venue algonquin = new AlgonquinCommonsTheatre("1385 Woodroffe Ave");
		season1.scheduleConcert(concert_1.getID(), scheduledDate, scheduledTime, algonquin);

		//schedule concert_2
		//if scheduled date is set before open date, should return null
		scheduledDate = LocalDate.of(2017, 5, 25);
		scheduledTime = LocalTime.of(6, 0);//time 6:00
		Venue cityHall = new OttawaChamberfest("110 Laurier Ave W");
		season1.scheduleConcert(concert_2.getID(), scheduledDate, scheduledTime, cityHall);
		
		//Now set concert_1 as already performed --------------------------------------
		LocalDate performedDate = LocalDate.of(2017, 5, 3);//performed date is different from scheduled date
		LocalTime performedTime = LocalTime.of(11, 10);//performed time is different from scheduled time
		season1.setPerformedDate(concert_1.getID(), performedDate, performedTime);
		
		//Find the last date of a soloist performed a given composition --------------
		int x = 0;
		Soloist sx = soloists.get(x);
		Composition cx = compo_solo_1;
		LocalDate lastDatePerformed = user.getLastDatePerformed(sx, cx, season1);

		//verify concert_1 has been added, and info can be retrieved:
		//soloist1 performed, so lastDatePerformed isn't null
		assertFalse("\t\tTest_SymphonyManagement.testBehaviors", lastDatePerformed == null);
		//verify the last date
		assertTrue("\t\tTest_SymphonyManagement.testBehaviors", lastDatePerformed.equals(LocalDate.of(2017, 5, 3)));
		
		//List all soloists in a season:------------------------------------------------------
		int seasonID_x = 1;
		ArrayList<Soloist> solos_x = user.getSoloists(seasonID_x);
		assertTrue("\t\tTest_SymphonyManagement.testBehaviors", solos_x.contains(soloist1));
		assertFalse("\t\tTest_SymphonyManagement.testBehaviors", solos_x.contains(soloist2));
		assertTrue("\t\tTest_SymphonyManagement.testBehaviors", solos_x.contains(soloist3));
		assertFalse("\t\tTest_SymphonyManagement.testBehaviors", solos_x.contains(soloist4));
		
	}
	
    /* ATTRIBUTES	-----------------------------------------------	*/
    private SymphonyUser user;
}