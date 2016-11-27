package symphony.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * SymphonyUser class in symphony.domain package
 */
public class SymphonyUser {
	/**
	 * constructor
	 * @param ctrl
	 */
	public SymphonyUser(ApplicationController ctrl){
		controller = ctrl;
	}

	/**
	 * add concert
	 * @param concert
	 * @param season
	 * @return
	 */
	public boolean addConcert(Concert concert, ConcertSeason season){
		return controller.addConcert(concert, season);
	}

	/**
	 * get last date a solist performed a given composition in a season
	 * @param soloist
	 * @param composition
	 * @param season
	 * @return
	 */
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition, ConcertSeason season){
		return controller.getLastDatePerformed(soloist, composition, season);
	}

	/**
	 * list all soloists in a season
	 * @param seasonID
	 * @return
	 */
	public ArrayList<Soloist> getSoloists(int seasonID){
		return controller.getSoloists(seasonID);
	}

	/**
	 * add a concert season
	 * @param openDate
	 * @param length
	 */
	public void addConcertSeason(LocalDate openDate, int length){
		controller.addConcertSeason(openDate, length);
	}

	/**
	 * retrieve a concert season
	 * @param seasonID
	 * @return
	 */
	public ConcertSeason getConcertSeason(int seasonID){
		return controller.getConcertSeason(seasonID);
	}

	/**
	 * get a list of concert seasons
	 * @return
	 */
	public ArrayList<ConcertSeason> getConcertSeasons(){
		return controller.getConcertSeasons();
	}

	/**
	 * entry point
	 * @param args
	 */
	public static void main(String[] args){
		//define controller:
		SymphonyManagement symphony = SymphonyManagement.getInstance();
		SymphonyUser user = new SymphonyUser(symphony);
		
		//add concert seasons
		user.addConcertSeason(LocalDate.of(2017, 1, 1), 30);
		user.addConcertSeason(LocalDate.of(2017, 3, 15), 10);
		
		//populate conductor list and soloist list
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
		
		//-------------------------------------------------------------
		System.out.println("Welcome to add a concert:\n");
		
		System.out.println("Step 1: add or select a concert season");				
		ConcertSeason season1 = user.getConcertSeason(1);
		System.out.println("\tConcert Season " + season1.getSeasonID() + 
				", open at " + season1.getOpenDate().getDayOfMonth() +
				"-" + season1.getOpenDate().getMonth() +
				"-" + season1.getOpenDate().getYear() + ", has been selected");
		
		System.out.println("\nStep 2: create a concert");	
		System.out.println("\tStep 2.1: select a conductor");
		Conductor cond1 = conductors.get(0);
		System.out.println("\t\tConductor: " + cond1.getName() + " has been selected");
		
		System.out.println("\n\tStep 2.2: select composition(s)");
		ArrayList<Composition> compositions_1 = new ArrayList<>();
		Composition compo1 = new Composition();
		compo1.setComposer("Bach");
		compo1.setCompositionName("BWV 1");
		Composition compo2 = new Composition();
		compo2.setComposer("Beethoven");
		compo2.setCompositionName("Symphony No.1");
		compositions_1.add(compo1);
		compositions_1.add(compo2);
		for(Composition c: compositions_1){
			System.out.println("\t\tCompositionID: " + c.getCompositionID() +
					", title: " + c.getCompositionName() +
					" by " + c.getComposer() + " has been selected");
		}
		
		System.out.println("\n\tStep 2.3: add movement(s)");
		System.out.println("\t\tNot now ...");
		
		System.out.println("\n\tStep 2.4: add composition(s) with soloist(s)");
		ArrayList<Composition_Soloist> compo_solos_1 = new ArrayList<>();
		ArrayList<Soloist> subSolos_1 = new ArrayList<>();
		subSolos_1.add(soloists.get(0));
		Composition_Soloist compo_solo_1 = new Composition_Soloist(subSolos_1);
		compo_solo_1.setComposer("Mozart");
		compo_solo_1.setCompositionName("Piano Concerto No.5");
		compo_solos_1.add(compo_solo_1);
		for(Composition_Soloist cs: compo_solos_1){
			for(Soloist s: subSolos_1){
				System.out.println("\t\tSoloist " + s.getName() + " will perform " +
			                        cs.getCompositionName() + " by " + cs.getComposer());
			}
		}
		compositions_1.addAll(compo_solos_1);//create list of composition w/ and w/o soloist
		
		System.out.println("\nStep 3: add the concert to the season");
		Concert concert_1 = new Concert(cond1, compositions_1);
		user.addConcert(concert_1, season1);
		System.out.println("\tConcertID: " + season1.getConcert(concert_1).getID() +
				" has been added to Season " + season1.getSeasonID());
		
		//add another concert -------------------------------------------------------------
		System.out.println("\n...........Add another concert..............");
        System.out.println("\nWelcome to add a concert:\n");
		
		System.out.println("Step 1: add or select a concert season");				
		System.out.println("\tConcert Season " + season1.getSeasonID() + 
				", open at " + season1.getOpenDate().getDayOfMonth() +
				"-" + season1.getOpenDate().getMonth() +
				"-" + season1.getOpenDate().getYear() + ", has been selected");
		
		System.out.println("\nStep 2: create a concert");	
		System.out.println("\tStep 2.1: select a conductor");
		Conductor cond2 = conductors.get(2);
		System.out.println("\t\tConductor: " + cond2.getName() + " has been selected");
		
		System.out.println("\n\tStep 2.2: select composition(s)");
		ArrayList<Composition> compositions_2 = new ArrayList<>();
		Composition compo3 = new Composition();
		compo3.setComposer("Mozart");
		compo3.setCompositionName("Violin Concerto No.1");
		compositions_2.add(compo3);
		for(Composition c: compositions_2){
			System.out.println("\t\tCompositionID: " + c.getCompositionID() +
					", title: " + c.getCompositionName() +
					" by " + c.getComposer() + " has been selected");
		}
		
		System.out.println("\n\tStep 2.3: add movement(s)");
		System.out.println("\t\tNot now ...");
		
		System.out.println("\n\tStep 2.4: add composition(s) with soloist(s)");
		ArrayList<Composition_Soloist> compo_solos_2 = new ArrayList<>();
		ArrayList<Soloist> subSolos_2 = new ArrayList<>();
		subSolos_2.add(soloists.get(0));
		subSolos_2.add(soloists.get(2));
		Composition_Soloist compo_solo_2 = new Composition_Soloist(subSolos_2);
		compo_solo_2.setComposer("Beethoven");
		compo_solo_2.setCompositionName("Piano Concerto No.0");
		compo_solos_2.add(compo_solo_2);
		for(Composition_Soloist cs: compo_solos_2){
			for(Soloist s: subSolos_2){
				System.out.println("\t\tSoloist " + s.getName() + " will perform " +
			                        cs.getCompositionName() + " by " + cs.getComposer());
			}
		}
		compositions_2.addAll(compo_solos_2);//create list of composition w/ and w/o soloist
		
		System.out.println("\nStep 3: add the concert to the season");
		Concert concert_2 = new Concert(cond2, compositions_2);
		user.addConcert(concert_2, season1);
		System.out.println("\tConcertID: " + season1.getConcert(concert_2).getID() +
				" has been added to Season " + season1.getSeasonID());
		
		//--------------------------------------------------------------------------
		System.out.println("\nNow schedule a concert:");
		
		//schedule concert_1
		LocalDate scheduledDate = LocalDate.of(2017, 1, 2);
		LocalTime scheduledTime = LocalTime.of(10, 30);//time 10:30
		Venue algonquin = new AlgonquinCommonsTheatre("1385 Woodroffe Ave");
		season1.scheduleConcert(concert_1.getID(), scheduledDate, scheduledTime, algonquin);
		System.out.println("\tConcertID: " + concert_1.getID() + 
				            " has been scheduled to perform on " +
		                    scheduledDate.getDayOfMonth() + "-" +
		                    scheduledDate.getMonth() + "-" +
		                    scheduledDate.getYear());
		
		//schedule concert_2
		scheduledDate = LocalDate.of(2017, 1, 25);
		scheduledTime = LocalTime.of(6, 0);//time 6:00
		Venue cityHall = new OttawaChamberfest("110 Laurier Ave W");
		season1.scheduleConcert(concert_2.getID(), scheduledDate, scheduledTime, cityHall);
		System.out.println("\tConcertID: " + concert_2.getID() + 
				            " has been scheduled to perform on " +
		                    scheduledDate.getDayOfMonth() + "-" +
		                    scheduledDate.getMonth() + "-" +
		                    scheduledDate.getYear());
		
		//-----------------------------------------------------------------------------
		System.out.println("\nNow set a concert as already performed:");
		LocalDate performedDate = LocalDate.of(2017, 1, 3);//performed date is different from scheduled date
		LocalTime performedTime = LocalTime.of(11, 10);//performed time is different from scheduled time
		season1.setPerformedDate(concert_1.getID(), performedDate, performedTime);
		System.out.println("\tConcertID: " + concert_1.getID() + 
	            " has been performed on " +
	            performedDate.getDayOfMonth() + "-" +
	            performedDate.getMonth() + "-" +
	            performedDate.getYear());
		
		System.out.println("\n...........Verify..........");
		System.out.println("\tHas concert " + concert_1.getID() + " already scheduled?");
		System.out.print("\t");
		System.out.println(season1.getConcert(concert_1.getID()).isScheduled());
		System.out.println("\tHas concert " + concert_2.getID() + " already scheduled?");
		System.out.print("\t");
		System.out.println(season1.getConcert(concert_2.getID()).isScheduled());
		System.out.println("\tHas concert " + concert_1.getID() + " already performed?");
		System.out.print("\t");
		System.out.println(season1.getConcert(concert_1.getID()).isPerformed());
		System.out.println("\tHas concert " + concert_2.getID() + " already performed?");
		System.out.print("\t");
		System.out.println(season1.getConcert(concert_2.getID()).isPerformed());
		
		//-----------------------------------------------------------
		System.out.println("\nFind the last date of a soloist performed a given composition:");
		int x = 0;
		Soloist sx = soloists.get(x);
		Composition cx = compo_solo_1;
		ConcertSeason csx = season1;
		System.out.println("\tWhat is the last date " + sx.getName() + 
				" performed composition " + cx.getCompositionName() + "?");
		LocalDate lastDatePerformed = user.getLastDatePerformed(sx, cx, csx);
		if(lastDatePerformed == null) {
			System.out.println("\tNo date found, "
					+ "either the soloist doesn't exist, or didn't perform the composition");
		}
		else{
			System.out.println("\tThe last date soloist " + sx.getName() +
					" performed composition " + cx.getCompositionName() + " is " +
			        lastDatePerformed.getDayOfMonth() + "-" +
					lastDatePerformed.getMonth() + "-" +
					lastDatePerformed.getYear());
			
			System.out.println("\n\tWhat is the expertise of this soloist?");
			ArrayList<String> expertises = (ArrayList<String>)sx.getExpertises();
			for(String expertise: expertises){
				System.out.println("\tExpert in " + expertise);
			}
			
			System.out.println("\n\tWhat is phone of this soloist?");
			if(sx.getPhone().isEmpty()){
				System.out.println("\tNo phone record is found");
			}
			else{
				System.out.println("\tThe phone number is " + sx.getPhone());
			}
			
			System.out.println("\n\tWhat is address of this soloist?");
			if(sx.getAddress().isEmpty()){
				System.out.println("\tNo address record is found");
			}
			else{
				System.out.println("\tThe address is " + sx.getAddress());
			}
		}
		
		//-----------------------------------------------------------
		System.out.println("\nList all soloists in a season: enter season id here");
		int seasonID_x = 1;
		ArrayList<Soloist> solos_x = user.getSoloists(seasonID_x);
		if(solos_x == null || solos_x.isEmpty()){//null when no composition selected, empty when no soloist assigned
			System.out.println("\tNo soloist found, either the season entered is invalid or the season doesn't have any soloist");
		}
		else{
			ArrayList<String> solo_List = new ArrayList<>();
			for(Soloist s: solos_x){
				String sName = s.getName();
				//To avoid show duplicate soloist: more efficient way is to use Set<>, Comparable<Soloist>
				//but need first to override equals() and hasCode() in Soloist class
				if(!solo_List.contains(sName)){
					solo_List.add(sName);
					System.out.println("\tIn season " + seasonID_x +
				            ", there is soloist: " + sName);
				}
			}
		}
		
		symphony = null;

	}
	//---- Attributes -------------------------------------
	private ApplicationController controller;
}
