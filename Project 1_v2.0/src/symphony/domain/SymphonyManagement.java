package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * class SymphonyManagement in symphony.domain package
 */
public class SymphonyManagement implements ApplicationController {

	/**
	 * no-arg constructor: initialize list of seasons
	 */
	private SymphonyManagement(){
		seasons = new ArrayList<>();
	}
	
	/**
	 * return this class instance
	 * @return SymphonyManagement instance
	 */
	public static SymphonyManagement getInstance(){
		if(managerInstance == null) {
			synchronized(SymphonyManagement.class){// thread-safe
				if(managerInstance == null){
					managerInstance = new SymphonyManagement();
				}			
			} 
		}
		return managerInstance;
	}
	
	/**
	 * add a concert in a season
	 * @param concert concert instance
	 * @param ConcertSeason ConcertSeason instance
	 * @return true when success add concert in season else false
	 */
	public boolean addConcert(Concert concert, ConcertSeason season){
		return season.addConcert(concert);
	}

	/**
	 * add a concert season
	 * @param openDate concert season open date
	 * @param length concert season length
	 * @return true when success add concert season else false
	 */
	@Override
	public boolean addConcertSeason(LocalDate openDate, int length) {
		LocalDate nowDate = LocalDate.now();
		if(nowDate.isAfter(openDate)) return false;//if open date has already passed, no adding allowed
		ConcertSeason season = new ConcertSeason(openDate, length);
		season.setSeasonID(++sid);
		seasons.add(season);
		return true;
	}
	
	/**
	 * overload: add a concert season 
	 * @param season  concert season instance
	 * @return true when add concert season 
	 */
	public boolean addConcertSeason(ConcertSeason season) {
		season.setSeasonID(++sid);
		seasons.add(season);
		return true;
	}

	/**
	 * get the last date a soloist performed a given composition in a season
	 * @param soloist soloist instance
	 * @param composition composition instance
	 * @param ConcertSeason ConcertSeason instance
	 * @return the last date a soloist performed a given composition in a season
	 */
	@Override
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition, ConcertSeason season) {
		return season.getLastDatePerformed(soloist, composition);
	}
	
	/**
	 * get a list of concert seasons
	 * @return a list of concert seasons
	 */
	public ArrayList<ConcertSeason> getConcertSeasons(){
		return seasons;
	}
	
	/**
	 * get a concert season by its id
	 * @param seasonID concert season id
	 * @return a concert season by its id
	 */
	public ConcertSeason getConcertSeason(int seasonID){
		for(ConcertSeason cs: seasons){
			if(cs.getSeasonID() == seasonID) return cs;
		}
		return null;
	}
	
	/**
	 * get a concert season id by its object
	 * @param season season instance
	 * @return a concert season id 
	 */
	public int getSeasonID(ConcertSeason season){
		for(ConcertSeason cs: seasons){
			if(cs.getOpenDate().equals(season.getOpenDate())) {
				//if two season have the same open date, then they are the same season
				return cs.getSeasonID();
			}
		}
		return -1;//-1 means no match
	}
	
	/**
	 * list all soloists in a season (by season id)
	 * @param seasonID concert season id
	 * @return all soloists in a season (by season id)
	 */
	public ArrayList<Soloist> getSoloists(int seasonID){
		ArrayList<Soloist> soloists = new ArrayList<>();
		ConcertSeason cs = getConcertSeason(seasonID);
		if(cs == null) return null;
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

	//ATTRIBUTES --------------------------------------------
	/** SymphonyManagement instance */
	private static SymphonyManagement managerInstance;
	/** season id*/
	private static int sid = 0;// season id which is assigned to a newly added season
	/** concert season list */
	private ArrayList<ConcertSeason> seasons;
	
}
