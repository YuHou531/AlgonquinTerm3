package symphony.domain;

import java.util.ArrayList;

/**
 * class Solist in symphony.domain package
 */
public class Soloist extends Artist{
	/**
	 * constructor
	 * @param b
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
		 * @param id
		 * @param name
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
		 */
		public Soloist build(){
			return new Soloist(this);
		}
	}
	
	/**
	 * get the list of expertise area of this soloist
	 * @return
	 */
	public ArrayList<String> getExpertises(){
		return expertises;
	}
	
	//ATTRIBUTES ------------------------------------
	private ArrayList<String> expertises;
	
}