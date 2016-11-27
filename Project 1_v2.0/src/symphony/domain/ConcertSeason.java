package symphony.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * class ConcertSeason in symphony.domain package
 */
public class ConcertSeason {
	
	/**
	 * constructor
	 * @param openDate
	 * @param length
	 */
	public ConcertSeason(LocalDate openDate, int length){		
		setOpenDate(openDate);
		setLength(length);
		concerts = new ArrayList<Concert>();
	}
	
	/**
	 * add a concert
	 * @param concert
	 * @return
	 */
	public boolean addConcert(Concert concert){
		LocalDate currentDate = LocalDate.now();
		LocalDate opendate = getOpenDate();
		if(currentDate.isBefore(openDate)){
			concert.setID("Concert " + (++cid));//when add a concert, it's given an id
			concerts.add(concert);
			return true;
		}
		else{
			return false;//if current date is later than openDate, not allowed to add
		}
	}
	
	/**
	 * set season id
	 * @param seasonID
	 */
	public void setSeasonID(int seasonID){
		this.seasonID = seasonID;
	}
	
	/**
	 * set season open date
	 * @param date
	 */
	public void setOpenDate(LocalDate date){
		openDate = date;
	}
	
	/**
	 * set season length in days
	 * @param duration
	 */
	public void setLength(int duration){
		length = duration;
	}
	
	/**
	 * get season id
	 * @return
	 */
	public int getSeasonID(){
		return seasonID;
	}
	
	/**
	 * get season open date
	 * @return
	 */
	public LocalDate getOpenDate(){
		return openDate;
	}
	
	/**
	 * get season length
	 * @return
	 */
	public int getLength(){
		return length;
	}

	/**
	 * get list of concerts in this season
	 * @return
	 */
	public ArrayList<Concert> getConcerts(){
		return concerts;
	}
	
	/**
	 * get a concert by its object
	 * @param concert
	 * @return
	 */
	public Concert getConcert(Concert concert){
		if(concerts.isEmpty() || concerts == null) return null;
		int index = concerts.indexOf(concert);
		if(index == -1) return null;
		return concerts.get(index);
	}

	/**
	 * get a concert by its id
	 * @param concertID
	 * @return
	 */
	public Concert getConcert(String concertID){
		if(concerts.isEmpty() || concerts == null) return null;
		for(Concert c: concerts){
			if(c.getID().equals(concertID)) return c;
		}
		return null;
	}
	
	/**
	 * get list of performed concerts in this season
	 * @return
	 */
	public ArrayList<PerformedConcert> getPerformedConcerts(){
		ArrayList<PerformedConcert> performedConcerts = new ArrayList<>();
		for(Concert c: concerts){
			if(c.isPerformed()){
				performedConcerts.add((PerformedConcert)c);
			}
		}
		return performedConcerts;
	}
	
	/**
	 * set date, time and venue, a concert becomes a scheduled concert
	 * @param concert
	 * @param date
	 * @param venue
	 * @return
	 */
	public boolean scheduleConcert(String concertID, LocalDate date, LocalTime time, Venue venue){
		//scheduled means not only date/time but also location is determined
		if(date.isBefore(openDate)) return false;//if scheduled date is before open date, it's invalid
		
		if(date.isAfter(openDate.plusDays(length))) return false;//if scheduled date is after end date, not allowed to schedule
		
		Concert concert = this.getConcert(concertID);
		if(concert.isPerformed()) {//if already performed, not allow to change scheduled date
			return false;
		}
		if(concert.isScheduled()) {//if already scheduled, reset scheduled date
			concert.setDate(date);//reset scheduled date
			((ScheduledConcert)concert).setVenue(venue);//reset location
			return true;
		}
		//if not scheduled, create a new scheduled concert
		ScheduledConcert sc = new ScheduledConcert(concert);
		sc.setDate(date);//set scheduled date
		sc.setTime(time);//set scheduled time (hour, minute)
		sc.setVenue(venue);//set location			
		concerts.add(sc);
		concerts.remove(concert);
		return true;	
	}
	
	/**
	 * set performed date/time, a scheduled concert becomes a performed concert
	 * @param concert
	 * @param date
	 * @return
	 */
	public boolean setPerformedDate(String concertID, LocalDate date, LocalTime time){
		//if performed date is before open date, it's invalid
		if(date.isBefore(openDate)) return false;
		
		//if performed date is after end date, not allowed to set
		if(date.isAfter(openDate.plusDays(length))) return false;
		
		Concert concert = this.getConcert(concertID);
		if(concert.isPerformed()) {//reset performed date -- or not allowed???
			concert.setDate(date);
			return true;
		}
		if(concert.isScheduled()) {
			//if scheduled and performed, convert this concert to a new performed concert
			
			//if performed date is before scheduled date, it's invalid????
			//LocalDate scheduledDate = concert.getDate();
			//if(date.isBefore(scheduledDate)) return false;
			
			PerformedConcert pc = new PerformedConcert(concert);
			pc.setDate(date);
			pc.setTime(time);
			concerts.remove(concert);
			concerts.add(pc);
			return true;
		}
		//if not scheduled, not allow to set performed date
		return false;
	}
	
	/**
	 * get the last date a soloist performed a given composition
	 * @param soloist
	 * @param composition
	 * @return
	 */
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition){
		ArrayList<PerformedConcert> performedConcerts = getPerformedConcerts();
		ArrayList<LocalDate> dates = new ArrayList<>();
		if(performedConcerts.isEmpty())return null;
		for(PerformedConcert pc: performedConcerts){
			LocalDate date = pc.getDate();
			ArrayList<Composition> compositions = pc.getCompositions();
			for(Composition c: compositions){
				if(!c.hasSoloist())continue;//if this is a composition without a soloist, search next
				if(c.getCompositionID().equals(composition.getCompositionID())){
					ArrayList<Soloist> soloists = ((Composition_Soloist)c).getSoloists();
					if(soloists.contains(soloist)){
						dates.add(date);
					}
				}
			}
		}
		if(dates.isEmpty())return null;
		Collections.sort(dates);// sort the dates, the last one is the latest date
		return dates.get(dates.size()-1);
	}
	
	//ATTRIBUTES----------------------------------------------
	private int seasonID;
	private LocalDate openDate;
	private int length;
	private ArrayList<Concert> concerts;
	private static int cid = 0;//concert's id (number part)
	
}
