package symphony.domain;

/**
 * class PerformedConcert in symphony.domain package
 */
public class PerformedConcert extends ScheduledConcert {

	/**
	 * constructor
	 * @param concert
	 */
	public PerformedConcert(Concert concert){
		super(concert);
		setPerformed(true);
	}
}
