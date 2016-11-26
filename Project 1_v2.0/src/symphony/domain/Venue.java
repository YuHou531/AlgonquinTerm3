package symphony.domain;

public abstract class Venue {
	protected String address;
	protected int[] seats;
	
	public Venue(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setSeats(int number){
		seats = new int[number];
	}
	
	public int getSeat(int seatNumber){
		if(seatNumber > seats.length) return -1;
		return seats[seatNumber];
	}
	
	public abstract boolean hasDiscount();
}
