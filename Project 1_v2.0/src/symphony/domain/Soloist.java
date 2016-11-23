package symphony.domain;

import java.util.ArrayList;
import java.util.List;

public class Soloist extends Artist{
	private List<String> expertises;
	
	private Soloist(Builder b){
		super(b);
		expertises = b.expertises;
	}
	
	public static class Builder extends Artist.Builder{
		private List<String> expertises = new ArrayList<>();
		
		public Builder(String id, String name){
			super(id, name);
		}
		///*
		public Builder addExpertise(String expertise){
			//super.addExpertise(expertise);
			expertises.add(expertise);
			return this;
		}//*/
		
		public Soloist build(){
			return new Soloist(this);
		}
	}
	
	public List<String> getExpertises(){
		return expertises;
	}
}