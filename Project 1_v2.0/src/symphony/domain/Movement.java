package symphony.domain;

/**
 * class Movement in symphony.domain package
 */
public class Movement {
	/**
	 * constructor
	 * @param id
	 * @param name
	 */
	public Movement(int id, String name){
		movementID = id;
		this.name = name; 
	}
	
	/**
	 * get movement id
	 * @return
	 */
	public int getID(){
		return movementID;
	}
	
	/**
	 * get movement name
	 * @return
	 */
	public String getName(){
		return name;
	}

	//ATTRIBUTES------------------------
	private int movementID;
	private String name;
	
}
