package symphony.domain;

/**
 * abstract class Venue in symphony.domain package
 */
public abstract class Venue {
	
	/**
	 * constructor
	 * @param address
	 */
	public Venue(String address){
		this.address = address;
	}
	
	/**
	 * get venue's address
	 * @return
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * set seats in this venue
	 * @param number
	 */
	public void setSeats(int number){
		seats = new int[number];
		for(int i = 0; i < number; i++){
			seats[i] = i+1;
		}
	}
	
	/**
	 * get a seat by its number
	 * @param seatNumber
	 * @return
	 */
	public int getSeat(int seatNumber){
		if(seatNumber > seats.length) return -1;
		return seats[seatNumber];
	}
	
	/**
	 * abstract method
	 * @return
	 */
	public abstract boolean hasDiscount();
	
	//ATTRIBUTES ---------------------------------
	protected String address;
	protected int[] seats;
	
}
