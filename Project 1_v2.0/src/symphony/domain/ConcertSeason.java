package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ConcertSeason {
	private String seasonID;
	private LocalDate openDate;
	private int length;
	private ArrayList<Concert> concerts;
	private ArrayList<ScheduledConcert> scheduledConcerts;
	private ArrayList<PerformedConcert> performedConcerts;
	private int CID = 0;//concert's id (number part)
	
	public ConcertSeason(LocalDate openDate, int length){
		setOpenDate(openDate);
		setLength(length);
		concerts = new ArrayList<Concert>();
		scheduledConcerts = new ArrayList<ScheduledConcert>();
		performedConcerts = new ArrayList<PerformedConcert>();
	}
	
	public boolean addConcert(Concert concert){
		LocalDate currentDate = LocalDate.now();
		LocalDate opendate = getOpenDate();
		if(currentDate.isBefore(openDate)){
			CID++;
			concert.setID("Concert " + CID);
			concerts.add(concert);
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setOpenDate(LocalDate date){
		openDate = date;
	}
	
	public void setLength(int duration){
		length = duration;
	}
	
	public String getSeasonID(){
		return seasonID;
	}
	
	public LocalDate getOpenDate(){
		return openDate;
	}
	
	public int getLength(){
		return length;
	}

	public ArrayList<Concert> getConcerts(){
		return concerts;
	}
	
	public Concert getConcert(Concert concert){
		if(concerts == null) return null;
		int index = concerts.indexOf(concert);
		if(index == -1) return null;
		return concerts.get(index);
	}
	
	public Concert getConcert(String concertID){
		if(concerts == null) return null;
		for(Concert c: concerts){
			if(c.getID().equals(concertID)) return c;
		}
		return null;
	}
	
	public ArrayList<PerformedConcert> getPerformedConcerts(){
		return performedConcerts;
	}
	
	public boolean setScheduledDate(Concert concert, LocalDate date){
		if(concert.isPerformed()) {//if already performed, not allow to change scheduled date
			return false;
		}
		if(concert.isScheduled()) {//if already scheduled, reset scheduled date
			concert.setDate(date);;
			return true;
		}
		//if not scheduled, create a new scheduled concert
		ScheduledConcert sc = new ScheduledConcert(concert);
		sc.setDate(date);
		concerts.remove(concert);
		scheduledConcerts.add(sc);
		return true;
	}
	
	public boolean setPerformedDate(Concert concert, LocalDate date){
		if(concert.isPerformed()) {//reset performed date -- or not allowed???
			concert.setDate(date);
			return true;
		}
		if(concert.isScheduled()) {
			//if scheduled and performed, convert this concert to a new performed concert
			PerformedConcert pc = new PerformedConcert(concert);
			pc.setDate(date);
			scheduledConcerts.remove(concert);
			performedConcerts.add(pc);
			return true;
		}
		//if not scheduled, not allow to set performed date
		return false;
	}
	
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition){
		ArrayList<PerformedConcert> performedConcerts = getPerformedConcerts();
		ArrayList<LocalDate> dates = new ArrayList<>();
		if(performedConcerts.isEmpty())return null;
		for(PerformedConcert pc: performedConcerts){
			LocalDate date = pc.getDate();
			//ArrayList<Composition_Soloist> comp_solos = (ArrayList<Composition_Soloist>)pc.getCompositionSoloists();
			ArrayList<Composition> compositions = pc.getCompositions();
			for(Composition c: compositions){
				if(!c.hasSoloist())continue;
				if(c.getCompositionID().equals(composition.getCompositionID())){
					ArrayList<Soloist> soloists = ((Composition_Soloist)c).getSoloists();
					if(soloists.contains(soloist)){
						dates.add(date);
					}
				}
			}
		}
		if(dates.isEmpty())return null;
		Collections.sort(dates);
		return dates.get(dates.size()-1);
	}
}
