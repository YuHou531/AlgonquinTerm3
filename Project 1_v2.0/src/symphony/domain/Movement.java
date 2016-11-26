package symphony.domain;

public class Movement {
	private int movementID;
	private String name;
	
	public Movement(int id, String name){
		movementID = id;
		this.name = name; 
	}
	
	public int getID(){
		return movementID;
	}
	
	public String getName(){
		return name;
	}

}
