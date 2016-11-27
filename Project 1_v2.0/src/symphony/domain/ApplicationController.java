package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Interface ApplicationController in symphony.domain package
 */
public interface ApplicationController {

	/**
	 * add concert
	 * @param concert
	 * @param season
	 * @return
	 */
	public boolean addConcert(Concert concert, ConcertSeason season);

	/**
	 * add a concert season
	 * @param date
	 * @param length
	 * @return
	 */
	public boolean addConcertSeason(LocalDate date, int length);
	
	/**
	 * get a concert season
	 * @param seasonID
	 * @return
	 */
	public ConcertSeason getConcertSeason(int seasonID);
	
	/**
	 * get list of concert seasons
	 * @return
	 */
	public ArrayList<ConcertSeason> getConcertSeasons();
	
	/**
	 * get the last date a soloist performed a given composition in a season
	 * @param soloist
	 * @param composition
	 * @param season
	 * @return
	 */
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition, ConcertSeason season);

	/**
	 * list all soloists in a season
	 * @param seasonID
	 * @return
	 */
	public ArrayList<Soloist> getSoloists(int seasonID);
}
