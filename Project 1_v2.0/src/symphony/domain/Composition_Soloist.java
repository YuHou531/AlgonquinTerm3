package symphony.domain;

import java.util.ArrayList;

/**
 * class Composition_Soloist, subclass of class Composition, has soloist information
 */
public class Composition_Soloist extends Composition {
	
	/**
	 * constructor for Composition_Soloist
	 * @param soloists soloists list
	 */
	public Composition_Soloist(ArrayList<Soloist> soloists){
		super();
		this.soloists = soloists;
		//hasSoloist = true;
		soloistAssigned(true);
	}

	/**
	 * get soloist list
	 * @return soloists list
	 */
	public ArrayList<Soloist> getSoloists(){
		return soloists;
	}

	/**
	 * add a soloist
	 * @param soloist the soloist to add
	 */
	public void addSoloist(Soloist soloist){
		soloists.add(soloist);
	}
	
	/**
	 * get soloist by ID
	 * @param soloistID soloist ID
	 * @return soloist object
	 */
	public Soloist getSoloist(String soloistID){
		for(Soloist s: soloists){
			if(s.getID().equals(soloistID)){
				return s;
			}
		}
		return null;
	}
	
	/**
	 * delete soloist by ID
	 * @param soloistID soloist ID
	 * @return true if found the soloist ID, or else false
	 */
	public boolean deleteSoloist(String soloistID){
		for(Soloist s: soloists){
			if(s.getID().equals(soloistID)){
				soloists.remove(s);
				return true;
			}
		}
		return false;
	}
	
	//ATTRIBUTES--------------------------------------
	/**soloist list*/
	private ArrayList<Soloist> soloists;
}
