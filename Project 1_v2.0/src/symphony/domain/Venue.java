package symphony.domain;

/**
 * abstract class Venue in symphony.domain package
 */
public abstract class Venue {
	
	/**
	 * constructor for Venue
	 * @param address - Venue address
	 */
	public Venue(String address){
		this.address = address;
	}
	
	/**
	 * get venue's address
	 * @return String of venue's address
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * set seats in this venue
	 * @param number number of seats in this venue
	 */
	public void setSeats(int number){
		seats = new int[number];
		for(int i = 0; i < number; i++){
			seats[i] = i+1;
		}
	}
	
	/**
	 * get a seat by its number
	 * @param seatNumber the seat number
	 * @return the seat by its number
	 */
	public int getSeat(int seatNumber){
		if(seatNumber > seats.length) return -1;
		return seats[seatNumber];
	}
	
	/**
	 * abstract method
	 * @return true when there is discount
	 * @return false when there is not discount
	 */
	public abstract boolean hasDiscount();
	
	//ATTRIBUTES ---------------------------------
	/** 
	 * venue address
	 */
	protected String address;
	/** 
	 * venue seats
	 */
	protected int[] seats;
	
}
