package symphony.domain;

/**
 * ScheduledConcert used to represent schedule a concert
 * 
 * @author    Yu Hou
 * @version   Nov 24 2016
 *
 */
public class ScheduledConcert extends Concert {
	
	/**
	 * Venue instance represents scheduled concert
	 */
	private Venue venue;

	/**
	 * Constructor - used to represent scheduled concert
	 * 
	 * @param concert - concert instance for scheduled concert 
	 */
	public ScheduledConcert(Concert concert){
		super(concert.getConductor(), concert.getCompositions());
		setID(concert.getID());
		setConductor(concert.getConductor());
		setCompositions(concert.getCompositions());
		setScheduled(true);
	}
	
	/**
	 * Used to set venue for concert
	 * 
	 * @param v the venue for concert
	 */
	public void setVenue(Venue v){
		venue = v;
	}
	
	/**
	 * Used to get venue for concert
	 */
	public Venue getVenue(){
		return venue;
	}
}
