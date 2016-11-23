package symphony.domain;

import java.util.ArrayList;

public class Composition_Soloist extends Composition {
	private ArrayList<Soloist> soloists;
	
	public Composition_Soloist(String compositionID){
		super(compositionID);
		soloists = new ArrayList<>();
		//hasSoloist = true;
		soloistAssigned(true);
	}
	/*
	public Composition_Soloist(String CID, ArrayList<Soloist> soloists){
		//????????????
		hasSoloist = true;
	}*/
	
	public ArrayList<Soloist> getSoloists(){
		return soloists;
	}

	public void addSoloist(Soloist soloist){
		soloists.add(soloist);
	}
	
	public Soloist getSoloist(String soloistID){
		for(Soloist s: soloists){
			if(s.getID().equals(soloistID)){
				return s;
			}
		}
		return null;
	}
	
	public boolean deleteSoloist(String soloistID){
		for(Soloist s: soloists){
			if(s.getID().equals(soloistID)){
				soloists.remove(s);
				return true;
			}
		}
		return false;
	}
}
