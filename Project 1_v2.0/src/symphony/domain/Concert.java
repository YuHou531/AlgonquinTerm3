package symphony.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Concert {
	private boolean isScheduled;
	private boolean isPerformed;
	private LocalDate date;//this date can be scheduled or performed date
	private LocalTime time;//this time can be scheduled or performed time
	private String concertID;
	private Conductor conductor;
	private ArrayList<Composition> compositions;

	public Concert(Conductor conductor, ArrayList<Composition> compositions){
		this.conductor = conductor; 
		if(compositions.isEmpty()){
			compositions.add(new Composition());
		}
		this.compositions = compositions;		
	}

	public String getID(){
		return concertID;
	}
	
	public boolean setID(String concertID){
		if(isPerformed) return false;//if concert has performed, no setting allowed
		else{
			this.concertID = concertID;
			return true;
		}
	}
	
	public void setDate(LocalDate date){
		this.date = date;
	}
	
	public LocalDate getDate(){
		return date;
	}
	
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	public LocalTime getTime(){
		return time;
	}
	
	public boolean isScheduled(){
		return isScheduled;
	}
	
	public void setScheduled(boolean b){
		isScheduled = b;
	}
	
	public boolean isPerformed(){
		return isPerformed;
	}
	
	public void setPerformed(boolean b){
		isPerformed = b;
	}
	
	public void setConductor(Conductor conductor){
		this.conductor = conductor;
	}
	
	public Conductor getConductor(){
		return conductor;
	}

	public ArrayList<Composition> getCompositions(){
		return compositions;
	}

	public void setCompositions(ArrayList<Composition> compositions){
		this.compositions = compositions;
	}
}
