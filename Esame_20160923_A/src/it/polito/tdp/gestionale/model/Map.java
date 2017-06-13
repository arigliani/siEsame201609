package it.polito.tdp.gestionale.model;

import java.util.*;

public class Map {
	private HashMap<String,Wrap> map= new HashMap<String,Wrap>();
	
	public void put(String chiave,Studente s){
		if(this.map.containsKey(chiave)){
			map.get(chiave).add(s);
		}
		else{
			Set<Studente> listaStudenti= new HashSet<>();
			listaStudenti.add(s);
			Wrap p=new Wrap(listaStudenti,null);
			map.put(chiave, p);
		}
	}
	public void put(String chiave,Corso c){
		if(this.map.containsKey(chiave)){
			if(this.map.get(chiave).getC()==null){
				this.map.get(chiave).setC(c);
			}
		}else{
			Wrap p=new Wrap(null,c);
			map.put(chiave, p);
			
		}
	}
	
	public int size(){
		return this.map.size();
	}
	
	public Wrap get(String s){
		if(map.containsKey(s))
		  return map.get(s);
		else 
			return null;
	}
	@Override
	public String toString() {
		return "Map [map=" + map + "\n";
	}
	
	
	
	

}
