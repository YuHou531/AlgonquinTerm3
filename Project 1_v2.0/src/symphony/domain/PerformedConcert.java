package symphony.domain;

public class PerformedConcert extends ScheduledConcert {

	public PerformedConcert(Concert concert){
		super(concert);
		setPerformed(true);
	}
}
