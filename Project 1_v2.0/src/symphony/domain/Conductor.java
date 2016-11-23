package symphony.domain;

import java.util.ArrayList;
import java.util.List;

import symphony.domain.Soloist.Builder;

public class Conductor extends Artist {
	private Conductor(Builder b){
		super(b);
	}
	
	public static class Builder extends Artist.Builder{
		
		public Builder(String id, String name){
			super(id, name);
		}
		
		public Conductor build(){
			return new Conductor(this);
		}
	}
}