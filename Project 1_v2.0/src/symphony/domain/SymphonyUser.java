package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class SymphonyUser {
	
	public SymphonyUser(ApplicationController ctrl){
		controller = ctrl;
		//setController(ctrl);
	}
	/*
	public void setController(ApplicationController ctrl){
		controller = ctrl;
	}*/
	
	public boolean addConcert(Concert concert, ConcertSeason season){
		return controller.addConcert(concert, season);
	}

	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition, ConcertSeason season){
		return controller.getLastDatePerformed(soloist, composition, season);
	}
	
	public ArrayList<Soloist> getSoloists(String seasonID){
		return controller.getSoloists(seasonID);
	}
	
	public static void main(String[] args){
		
		Soloist soloist1 = (Soloist) new Soloist.Builder("solo 1", "Lang Lang")
				.addPhone("123-456").addExpertise("piano").addExpertise("violin").build();
		String soloPhone = soloist1.getPhone();
		System.out.println(soloPhone);
		String soloID = soloist1.getID();
		System.out.println(soloID);
		ArrayList<String> expertises = (ArrayList<String>)soloist1.getExpertises();
		for(String expertise: expertises){
			System.out.println(expertise);
		}
		
		Conductor conductor1 = (Conductor) new Conductor.Builder("cond 1", "Herbert von Karajan")
				.addPhone("789-012").build();
		String condPhone = conductor1.getPhone();
		System.out.println(condPhone);
		String condID = conductor1.getID();
		System.out.println(condID);
		
		//controller.addConcert(Concert concert, ConcertSeason season);
		//controller.addConcert();
		//((SymphonyManagement)controller).addConcert();
		//don't do it in static main()!!!! define in a separate method!!!
		
		//define controller:
		//SymphonyManagement symphony = new SymphonyManagement();
		SymphonyManagement symphony = SymphonyManagement.getInstance();
		SymphonyUser user = new SymphonyUser(symphony);
		//user.addConcert(concert, season);
	}
	
	private ApplicationController controller;
}
