package symphony.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ApplicationController {

	public boolean addConcert(Concert concert, ConcertSeason season);

	//public static void addConcertSeason();//abstract can't be static in interface
	public boolean addConcertSeason(ConcertSeason season);
	
	public LocalDate getLastDatePerformed(Soloist soloist, Composition composition, ConcertSeason season);

	public ArrayList<Soloist> getSoloists(String seasonID);
}
