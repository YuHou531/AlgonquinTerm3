package symphony.domain;

import java.util.ArrayList;
import java.util.List;

import symphony.domain.Soloist.Builder;

public abstract class Artist {
	private String id;
	private String name;
	private String address;
	private String phone;
	//private List<String> expertises;
	
	public static abstract class Builder{
		private String id;
		private String name;
		private String address = "";
		private String phone = "";
		//private List<String> expertises = new ArrayList<>();
		
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
		
		//public abstract Builder addExpertise(String expertise);
		///*
		public Builder addExpertise(String expertise){
			//expertises.add(expertise);
			return this;
		}//*/
		
		public abstract Artist build();
	}
	
	protected Artist(Builder b){
		id = b.id;
		name = b.name;
		address = b.address;
		phone = b.phone;
		//expertises = b.expertises;
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
	/*
	public List<String> getExpertises(){
		return expertises;
	}*/
}
