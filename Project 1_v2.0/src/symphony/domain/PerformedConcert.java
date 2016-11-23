package symphony.domain;

import java.time.LocalDate;
import java.util.List;

public class PerformedConcert extends ScheduledConcert {
	/*
	private LocalDate performedDate;
	
	public PerformedConcert(Conductor conductor, 
			List<Composition> compositions, 
			LocalDate scheduledDate, LocalDate performedDate){
		super(conductor, compositions, scheduledDate);
		setPerformedDate(performedDate);
	}

	public boolean setPerformedDate(LocalDate date){
		LocalDate currentDate = LocalDate.now();
		if(!currentDate.isBefore(date)){
			return false;
		}
		else{
			performedDate = date;
			isPerformed = true;
			return true;
		}
	}
	
	public LocalDate getPerformedDate(){
		return performedDate;
	}*/
	
	public PerformedConcert(Concert concert){
		super(concert);
		//setScheduledDate(concert.getScheduledDate());
		//setDate(concert.getDate());
		setPerformed(true);
	}
}
