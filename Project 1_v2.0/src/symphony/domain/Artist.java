package symphony.domain;

public abstract class Artist {
	private String id;
	private String name;
	private String address;
	private String phone;
	
	public static abstract class Builder{
		private String id;
		private String name;
		private String address = "";
		private String phone = "";
		
		public Builder(String id, String name){
			this.id = id;
			this.name = name;
		}
		
		public Builder addAddress(String address){
			this.address = address;
			return this;
		}
		
		public Builder addPhone(String phone){
			this.phone = phone;
			return this;
		}
		
		public Builder addExpertise(String expertise){
			return this;
		}
		
		public abstract Artist build();
	}
	
	protected Artist(Builder b){
		id = b.id;
		name = b.name;
		address = b.address;
		phone = b.phone;
	}
	
	public String getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getPhone(){
		return phone;
	}
	
}
