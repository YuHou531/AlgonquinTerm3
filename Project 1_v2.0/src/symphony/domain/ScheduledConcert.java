package symphony.domain;

import java.time.LocalDate;
import java.util.List;

public class ScheduledConcert extends Concert {
	/*
	public ScheduledConcert(Conductor conductor, List<Composition> compositions, LocalDate scheduledDate){
		super(conductor, compositions);
		setScheduledDate(scheduledDate);
	}

	public void setScheduledDate(LocalDate date){
		
	}*/
	
	public ScheduledConcert(Concert concert){
		super(concert.getConductor());
		setID(concert.getID());
		setConductor(concert.getConductor());
		setCompositions(concert.getCompositions());
		setScheduled(true);
	}
}
