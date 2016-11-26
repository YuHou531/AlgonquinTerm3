package symphony.domain;

import java.util.ArrayList;

public class Composition {
	private String compositionID;
	private static int id = 0;//compositionID's number part
	private String compositionName;
	private String composer;
	private boolean hasSoloist;
	private ArrayList<Movement> movements;
	
	public Composition(){
		compositionID = "Composition "+ (++id);//when generate a new composition, it's given an id
		movements = new ArrayList<>();
		
	}

	public String getCompositionID(){
		return compositionID;
	}
	
	public void setCompositionName(String name){
		compositionName = name;
	}
	
	public String getCompositionName(){
		return compositionName;
	}
	
	public void setComposer(String composerName){
		composer = composerName;
	}
	
	public String getComposer(){
		return composer;
	}

	public boolean hasSoloist(){
		return hasSoloist;
	}
	
	public void soloistAssigned(boolean b){
		hasSoloist = b;
	}
	
	public void addMovement(Movement m){
		movements.add(m);
	}
	
	public ArrayList<Movement> getMovements(){
		return movements;
	}
}
