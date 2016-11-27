package symphony.domain;

/**
 * class ScheduledConcert in symphony.domain package
 */
public class ScheduledConcert extends Concert {

	/**
	 * constructor for ScheduledConcert
	 * @param concert concert instance
	 */
	public ScheduledConcert(Concert concert){
		super(concert.getConductor(), concert.getCompositions());
		setID(concert.getID());
		setConductor(concert.getConductor());
		setCompositions(concert.getCompositions());
		setScheduled(true);
	}
	
	/**
	 * set a venue to this concert
	 * @param v venue instance
	 */
	public void setVenue(Venue v){
		venue = v;
	}
	
	/**
	 * get the venue this concert is scheduled to
	 * @return venue instance
	 */
	public Venue getVenue(){
		return venue;
	}
	
	//ATTRIBUTES -------------------------------------
	/** venue instance */
	private Venue venue;
	
}
