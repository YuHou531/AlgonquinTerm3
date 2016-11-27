package symphony.domain;

import java.util.ArrayList;

/**
 * class Solist in symphony.domain package
 */
public class Soloist extends Artist{
	/**
	 * constructor for Soloist
	 * @param b Soloist instance
	 */
	private Soloist(Builder b){
		super(b);
		expertises = b.expertises;
	}
	
	/**
	 * inner class Builder
	 */
	public static class Builder extends Artist.Builder{
		private ArrayList<String> expertises = new ArrayList<>();
		
		/**
		 * constructor
		 * @param id   Soloist id 
		 * @param name Soloist name
		 */
		public Builder(String id, String name){
			super(id, name);
		}
	
		/**
		 * add expertise area to a soloist
		 */
		public Builder addExpertise(String expertise){
			expertises.add(expertise);
			return this;
		}
		
		/**
		 * return a Soloist instance
		 * @return Soloist instance
		 */
		public Soloist build(){
			return new Soloist(this);
		}
	}
	
	/**
	 * get the list of expertise area of this soloist
	 * @return list of expertise area of this soloist
	 */
	public ArrayList<String> getExpertises(){
		return expertises;
	}
	
	//ATTRIBUTES ------------------------------------
	/** list of expertise area of this soloist */
	private ArrayList<String> expertises;
	
}