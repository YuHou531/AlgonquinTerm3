package symphony.domain;

/**
 * class Movement in symphony.domain package
 */
public class Movement {
	/**
	 * constructor for Movement
	 * @param id   movement id
	 * @param name movement name
	 */
	public Movement(int id, String name){
		movementID = id;
		this.name = name; 
	}
	
	/**
	 * get movement id
	 * @return movement id
	 */
	public int getID(){
		return movementID;
	}
	
	/**
	 * get movement name
	 * @return movement name
	 */
	public String getName(){
		return name;
	}

	//ATTRIBUTES------------------------
	/** movement id */
	private int movementID;
	/** movement name */
	private String name;
	
}
