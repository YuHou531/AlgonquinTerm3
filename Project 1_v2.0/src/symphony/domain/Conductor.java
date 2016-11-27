package symphony.domain;

/**
 * class Conductor in symphony.domain package
 */
public class Conductor extends Artist {
	
	/**
	 * constructor
	 * @param b
	 */
	private Conductor(Builder b){
		super(b);
	}
	
	/**
	 * inner class Builder extends Artist's inner class Builder
	 */
	public static class Builder extends Artist.Builder{
		
		/**
		 * constructor
		 * @param id
		 * @param name
		 */
		public Builder(String id, String name){
			super(id, name);
		}
		
		/**
		 * return a Conductor instance
		 */
		public Conductor build(){
			return new Conductor(this);
		}
	}
}
