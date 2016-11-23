package symphony.domain;

import java.util.ArrayList;

public class Composition {
	private String compositionID;
	private String composer;
	private boolean hasSoloist;
	private ArrayList<Movement> movements;
	
	public Composition(){
		
	}
	
	public Composition(String compositionID){
		this.compositionID = compositionID;
		movements = new ArrayList<>();
	}

	public String getCompositionID(){
		return compositionID;
	}
	
	public boolean hasSoloist(){
		return hasSoloist;
	}
	
	public void soloistAssigned(boolean b){
		hasSoloist = b;
	}
}
