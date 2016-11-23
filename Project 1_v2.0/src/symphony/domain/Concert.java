package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concert {
	private boolean isScheduled;
	private boolean isPerformed;
	//private LocalDate scheduledDate;
	//private LocalDate performedDate;
	private LocalDate date;

	private String concertID;
	private Conductor conductor;
	private ArrayList<Composition> compositions;
	//private ArrayList<Composition_Soloist> comp_solos;
	
	/*
	public Concert(){
		conductor = new Conductor();
		//builder pattern makes no such constructor in Conductor
	}
	
	public Concert(){
		this(conductor);
	}*/
	
	public Concert(Conductor conductor){
		//minimum requirement for a new concert is
		//a conductor and a composition
		//this.conductor = conductor; 
		setConductor(conductor);
		compositions = new ArrayList<Composition>();
		compositions.add(new Composition());//???must at least set one composition??????
	}
	
	public Concert(Conductor conductor, ArrayList<Composition> compositions){
		this.conductor = conductor; 
		if(compositions.isEmpty()){
			compositions.add(new Composition());
		}
		this.compositions = compositions;		
	}
	
	public Concert(String concertID){
		this.concertID = concertID;
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
	/*
	public Concert setScheduledDate(LocalDate date){
		return new ScheduledConcert(this);
	}//*/
	/*
	public ArrayList<Composition_Soloist> getCompositionSoloists(){
		return comp_solos;
	}//*/
	
	public ArrayList<Composition> getCompositions(){
		return compositions;
	}

	public void setCompositions(ArrayList<Composition> compositions){
		this.compositions = compositions;
	}
}
