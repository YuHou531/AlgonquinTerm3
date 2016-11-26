package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class SymphonyManagement implements ApplicationController {

	private static SymphonyManagement managerInstance;
	private static int sid = 0;// season id which is assigned to a newly added season
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
	public boolean addConcertSeason(LocalDate date, int length) {
		ConcertSeason season = new ConcertSeason(date, length);
		season.setSeasonID(++sid);
		seasons.add(season);
		return true;
	}

	@Override
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition, ConcertSeason season) {
		return season.getLastDatePerformed(soloist, composition);
	}
	
	public ConcertSeason getConcertSeason(int seasonID){
		for(ConcertSeason cs: seasons){
			if(cs.getSeasonID() == seasonID) return cs;
		}
		return null;
	}
	
	public ArrayList<Soloist> getSoloists(int seasonID){
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
