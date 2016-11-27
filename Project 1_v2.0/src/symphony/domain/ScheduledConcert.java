package symphony.domain;

/**
 * class ScheduledConcert in symphony.domain package
 */
public class ScheduledConcert extends Concert {

	/**
	 * constructor
	 * @param concert
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
	 * @param v
	 */
	public void setVenue(Venue v){
		venue = v;
	}
	
	/**
	 * get the venue this concert is scheduled to
	 * @return
	 */
	public Venue getVenue(){
		return venue;
	}
	
	//ATTRIBUTES -------------------------------------
	private Venue venue;
	
}
