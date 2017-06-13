package it.polito.tdp.gestionale.model;

import java.util.*;

public class Wrap {
	private Set<Studente> s;
	private Corso c;
	
	public Wrap(Set<Studente> s, Corso c) {
		super();
		this.s = new HashSet();
		this.c = c;
	}

	public Set<Studente> getS() {
		return s;
	}

	public void setS(Set<Studente> s) {
		this.s = s;
	}

	public Corso getC() {
		return c;
	}

	public void setC(Corso c) {
		this.c = c;
	}
	
	public void add(Studente stu){
		s.add(stu);
	}

	@Override
	public String toString() {
		return "studenti" +s.size()+ ", c=" + c.getCodins() + "\n";
	}
	
	

}
