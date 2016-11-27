package symphony.domain;

/**
 * Abstract class Artist in symphony.domain package
 */
public abstract class Artist {
	/**
	 * abstract inner class Builder 
	 */
	public static abstract class Builder{
		private String id;
		private String name;
		private String address = "";
		private String phone = "";
		
		/**
		 * Builder constructor
		 * @param id   Artist id
		 * @param name Artist name
		 */
		public Builder(String id, String name){
			this.id = id;
			this.name = name;
		}
		
		/**
		 * add an artist address
		 * @param address the address for artist
		 * @return artist instance
		 */
		public Builder addAddress(String address){
			this.address = address;
			return this;
		}
		
		/**
		 * add an artist phone
		 * @param phone the phone for artist
		 * @return artist instance
		 */
		public Builder addPhone(String phone){
			this.phone = phone;
			return this;
		}
		
		/**
		 * add an artist's expertise area
		 * @param expertise the expertise for artist 
		 * @return artist instance
		 */
		public Builder addExpertise(String expertise){
			return this;
		}
		
		/**
		 * build an artist
		 * @return artist instance
		 */
		public abstract Artist build();
	}
	
	/**
	 * constructor
	 * @param b artist instance
	 */
	protected Artist(Builder b){
		id = b.id;
		name = b.name;
		address = b.address;
		phone = b.phone;
	}
	
	/**
	 * get an artist id
	 * @return artist ID
	 */
	public String getID(){
		return id;
	}
	
	/**
	 * get an artist name
	 * @return artist name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * get an artist address
	 * @return artist address
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * get an artist phone
	 * @return artist phone
	 */
	public String getPhone(){
		return phone;
	}
	
	//ATRIBUTES------------------------------
	/** artist id */
	private String id;
	/** artist name */
	private String name;
	/** artist address */
	private String address;
	/** artist phone */
	private String phone;
}
