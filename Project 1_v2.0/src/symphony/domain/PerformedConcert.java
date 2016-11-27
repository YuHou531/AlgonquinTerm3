package symphony.domain;

/**
 * class PerformedConcert in symphony.domain package
 */
public class PerformedConcert extends ScheduledConcert {

	/**
	 * constructor for PerformedConcert
	 * @param concert concert instance
	 */
	public PerformedConcert(Concert concert){
		super(concert);
		setPerformed(true);
	}
}
