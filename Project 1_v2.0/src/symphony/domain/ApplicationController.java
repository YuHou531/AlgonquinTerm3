package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ApplicationController {

	public boolean addConcert(Concert concert, ConcertSeason season);

	public boolean addConcertSeason(LocalDate date, int length);
	
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition, ConcertSeason season);

	public ArrayList<Soloist> getSoloists(int seasonID);
}
