package symphony.domain;

public class ScheduledConcert extends Concert {
	private Venue venue;

	public ScheduledConcert(Concert concert){
		super(concert.getConductor(), concert.getCompositions());
		setID(concert.getID());
		setConductor(concert.getConductor());
		setCompositions(concert.getCompositions());
		setScheduled(true);
	}
	
	public void setVenue(Venue v){
		venue = v;
	}
	
	public Venue getVenue(){
		return venue;
	}
}
