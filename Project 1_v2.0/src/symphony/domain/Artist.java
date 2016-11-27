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
		 * @param id
		 * @param name
		 */
		public Builder(String id, String name){
			this.id = id;
			this.name = name;
		}
		
		/**
		 * add an artist address
		 * @param address
		 * @return
		 */
		public Builder addAddress(String address){
			this.address = address;
			return this;
		}
		
		/**
		 * add an artist phone
		 * @param phone
		 * @return
		 */
		public Builder addPhone(String phone){
			this.phone = phone;
			return this;
		}
		
		/**
		 * add an artist's expertise area
		 * @param expertise
		 * @return
		 */
		public Builder addExpertise(String expertise){
			return this;
		}
		
		/**
		 * build an artist
		 * @return
		 */
		public abstract Artist build();
	}
	
	/**
	 * constructor
	 * @param b
	 */
	protected Artist(Builder b){
		id = b.id;
		name = b.name;
		address = b.address;
		phone = b.phone;
	}
	
	/**
	 * get an artist id
	 * @return
	 */
	public String getID(){
		return id;
	}
	
	/**
	 * get an artist name
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * get an artist address
	 * @return
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * get an artist phone
	 * @return
	 */
	public String getPhone(){
		return phone;
	}
	
	//ATRIBUTES------------------------------
	private String id;
	private String name;
	private String address;
	private String phone;
}
