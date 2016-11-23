package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class SymphonyManagement implements ApplicationController {

	private static SymphonyManagement managerInstance;
	private ArrayList<ConcertSeason> seasons;
	
	private SymphonyManagement(){
		seasons = new ArrayList<>();
	}
	
	public static SymphonyManagement getInstance(){
		if(managerInstance == null) {
			return new SymphonyManagement(); 
		}
		return managerInstance;
	}
	
	public boolean addConcert(Concert concert, ConcertSeason season){
		return season.addConcert(concert);
	}

	@Override
	public boolean addConcertSeason(ConcertSeason season) {
		seasons.add(season);
		return true;
	}

	@Override
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition, ConcertSeason season) {
		return season.getLastDatePerformed(soloist, composition);
	}
	
	public ConcertSeason getConcertSeason(String seasonID){
		for(ConcertSeason cs: seasons){
			if(cs.getSeasonID().equals(seasonID)) return cs;
		}
		return null;
	}
	
	public ArrayList<Soloist> getSoloists(String seasonID){
		ArrayList<Soloist> soloists = new ArrayList<>();
		ConcertSeason cs = getConcertSeason(seasonID);
		ArrayList<Concert> concerts = cs.getConcerts();
		for(Concert cct: concerts){
			ArrayList<Composition> compositions = cct.getCompositions();
			for(Composition c: compositions){
				if(c.hasSoloist()){
					soloists.addAll(((Composition_Soloist)c).getSoloists());
				}
			}
		}
		return soloists;
	}
}
