package symphony.domain;

/**
 * PerformedConcert used to represent performed concert
 * 
 * @author    Yu Hou
 * @version   Nov 24 2016
 *
 */
public class PerformedConcert extends ScheduledConcert {

	/**
	 * Constructor - used to represent a performed concert
	 * 
	 * @param concert - concert instance for performed concert
	 */
	public PerformedConcert(Concert concert){
		super(concert);
		setPerformed(true);
	}
}
