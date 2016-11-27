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
	 * @param conductor
	 * @param compositions
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
	 * @return
	 */
	public String getID(){
		return concertID;
	}
	
	/**
	 * Setter
	 * Set id for each concert
	 * @param concertID
	 * @return
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
	 * @param date
	 */
	public void setDate(LocalDate date){
		this.date = date;
	}
	
	/**
	 * get concert date
	 * @return
	 */
	public LocalDate getDate(){
		return date;
	}
	
	/**
	 * set concert time
	 * @param time
	 */
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	/**
	 * get concert time
	 * @return
	 */
	public LocalTime getTime(){
		return time;
	}
	
	/**
	 * Get conditional varaible
	 * @return
	 */
	public boolean isScheduled(){
		return isScheduled;
	}
	
	/**
	 * set a concert scheduled or not
	 * @param b boolean
	 */
	public void setScheduled(boolean b){
		isScheduled = b;
	}
	
	/**
	 * get conditional varaible
	 * @return
	 */
	public boolean isPerformed(){
		return isPerformed;
	}
	
	/**
	 * set concert performed or not
	 * @param b boolean
	 */
	public void setPerformed(boolean b){
		isPerformed = b;
	}
	
	/**
	 * set a conductor
	 * @param conductor
	 */
	public void setConductor(Conductor conductor){
		this.conductor = conductor;
	}
	
	/**
	 * get a conductor
	 * @return a conductor
	 */
	public Conductor getConductor(){
		return conductor;
	}

	/**
	 * get list of compositions in a concert
	 * @return
	 */
	public ArrayList<Composition> getCompositions(){
		return compositions;
	}

	/**
	 * set a concert's composition list
	 * @param compositions
	 */
	public void setCompositions(ArrayList<Composition> compositions){
		this.compositions = compositions;
	}
	
	//ATTIBUTES -----------------------------------------------------------
	private boolean isScheduled;
	private boolean isPerformed;
	private LocalDate date;//this date can be scheduled or performed date
	private LocalTime time;//this time can be scheduled or performed time
	private String concertID;
	private Conductor conductor;
	private ArrayList<Composition> compositions;
}
