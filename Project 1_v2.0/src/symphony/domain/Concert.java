package symphony.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * class Concert in symphony.domain package
 */
public class Concert {

	/**
	 * Concert constructor
	 * @param conductor    conductor instance
	 * @param compositions compositions details
	 */
	public Concert(Conductor conductor, ArrayList<Composition> compositions){
		this.conductor = conductor; 
		if(compositions.isEmpty()){
			compositions.add(new Composition());
		}
		this.compositions = compositions;		
	}

	/**
	 * Getter
	 * Get concert's id
	 * @return the ID of concert
	 */
	public String getID(){
		return concertID;
	}
	
	/**
	 * Setter
	 * Set id for each concert
	 * @param concertID
	 * @return true when setID success else false
	 */
	public boolean setID(String concertID){
		if(isPerformed) return false;//if concert has performed, no setting allowed
		else{
			this.concertID = concertID;
			return true;
		}
	}
	
	/**
	 * Setter
	 * @param date date for concert
	 */
	public void setDate(LocalDate date){
		this.date = date;
	}
	
	/**
	 * get concert date
	 * @return concert date
	 */
	public LocalDate getDate(){
		return date;
	}
	
	/**
	 * set concert time
	 * @param time time for concert
	 */
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	/**
	 * get concert time
	 * @return the concert time
	 */
	public LocalTime getTime(){
		return time;
	}
	
	/**
	 * Get conditional variable
	 * @return whether concert is scheduled
	 */
	public boolean isScheduled(){
		return isScheduled;
	}
	
	/**
	 * set a concert scheduled or not
	 * @param b boolean consert scheduled or not
	 */
	public void setScheduled(boolean b){
		isScheduled = b;
	}
	
	/**
	 * get conditional variable
	 * @return concert is performed or not
	 */
	public boolean isPerformed(){
		return isPerformed;
	}
	
	/**
	 * set concert performed or not
	 * @param b boolean concert performed or not
	 */
	public void setPerformed(boolean b){
		isPerformed = b;
	}
	
	/**
	 * set a conductor
	 * @param conductor conductor of the concert
	 */
	public void setConductor(Conductor conductor){
		this.conductor = conductor;
	}
	
	/**
	 * get a conductor
	 * @return a conductor for concert
	 */
	public Conductor getConductor(){
		return conductor;
	}

	/**
	 * get list of compositions in a concert
	 * @return list of compositions in a concert
	 */
	public ArrayList<Composition> getCompositions(){
		return compositions;
	}

	/**
	 * set a concert's composition list
	 * @param compositions conpositions in concert
	 */
	public void setCompositions(ArrayList<Composition> compositions){
		this.compositions = compositions;
	}
	
	//ATTIBUTES -----------------------------------------------------------
	/** concert scheduled value */
	private boolean isScheduled;
	/** concert performed value*/
	private boolean isPerformed;
	/** concert date */
	private LocalDate date;//this date can be scheduled or performed date
	/** concert time*/
	private LocalTime time;//this time can be scheduled or performed time
	/** concert unique ID*/
	private String concertID;
	/** concert conductor*/
	private Conductor conductor;
	/** concert compositions*/
	private ArrayList<Composition> compositions;
}
