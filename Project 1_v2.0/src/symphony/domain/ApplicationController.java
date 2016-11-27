package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Interface ApplicationController in symphony.domain package
 */
public interface ApplicationController {

	/**
	 * add concert
	 * @param concert concert instance
	 * @param season  season instance
	 * @return true when add concert success
	 * @return false when add concert fail
	 */
	public boolean addConcert(Concert concert, ConcertSeason season);

	/**
	 * add a concert season
	 * @param date   date for concert
	 * @param length length for concert
	 * @return true when add Concert season success
	 * @return false when add Concert season fail
	 */
	public boolean addConcertSeason(LocalDate date, int length);
	
	/**
	 * get a concert season
	 * @param seasonID concert season unique ID
	 * @return concert season instance
	 */
	public ConcertSeason getConcertSeason(int seasonID);
	
	/**
	 * get list of concert seasons
	 * @return the list of concert seasons
	 */
	public ArrayList<ConcertSeason> getConcertSeasons();
	
	/**
	 * get the last date a soloist performed a given composition in a season
	 * @param soloist soloist instance
	 * @param composition composition info
	 * @param season concert season 
	 * @return the date for concert performed
	 */
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition, ConcertSeason season);

	/**
	 * list all soloists in a season
	 * @param seasonID the concert season unique ID
	 * @return the details for soloists
	 */
	public ArrayList<Soloist> getSoloists(int seasonID);
}
