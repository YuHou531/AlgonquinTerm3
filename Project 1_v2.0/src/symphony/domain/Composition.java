package symphony.domain;

import java.util.ArrayList;

/**
 * class Composition in symphony.domain package
 */
public class Composition {
	/**
	 * constructor
	 */
	public Composition(){
		compositionID = "Composition "+ (++id);//when generate a new composition, it's given an id
		movements = new ArrayList<>();
		
	}

	/**
	 * get composition id
	 * @return composition id
	 */
	public String getCompositionID(){
		return compositionID;
	}
	
	/**
	 * set compositon name
	 * @param name composition name
	 */
	public void setCompositionName(String name){
		compositionName = name;
	}
	
	/**
	 * get compositon name
	 * @return composition name
	 */
	public String getCompositionName(){
		return compositionName;
	}
	
	/**
	 * set composer
	 * @param composerName composer name
	 */
	public void setComposer(String composerName){
		composer = composerName;
	}
	
	/**
	 * get composer
	 * @return composer name
	 */
	public String getComposer(){
		return composer;
	}

	/**
	 * get if the compositon has soloist or not
	 * @return true if has, or else false
	 */
	public boolean hasSoloist(){
		return hasSoloist;
	}
	
	/**
	 * set the composition has soloist or not
	 * @param b has soloist or not
	 */
	public void soloistAssigned(boolean b){
		hasSoloist = b;
	}
	
	/**
	 * add a movement to the composition
	 * @param m the movement to add
	 */
	public void addMovement(Movement m){
		movements.add(m);
	}
	
	/**
	 * get movement list
	 * @return movement list
	 */
	public ArrayList<Movement> getMovements(){
		return movements;
	}
	
	//ATTRIBUTES-------------------------------------
	/**composition ID*/
	private String compositionID;
	/**compositionID's number part*/
	private static int id = 0;//compositionID's number part
	/**composition name*/
	private String compositionName;
	/**composer*/
	private String composer;
	/**if the composition has soloist or not*/
	private boolean hasSoloist;
	/**movement list*/
	private ArrayList<Movement> movements;
}
