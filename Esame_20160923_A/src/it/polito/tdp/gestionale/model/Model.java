package it.polito.tdp.gestionale.model;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.gestionale.db.DidatticaDAO;

public class Model {
	
	private  SimpleGraph<Nodo, DefaultEdge> graph  ;
	private Map m;
	
	public void creaGrafo(){
		if(this.graph==null){
			this.graph = new SimpleGraph<>(DefaultEdge.class) ;
			DidatticaDAO dao= new DidatticaDAO();
			m=new Map();
			List<Corso> corsi=dao.ListaCorso();
			dao.ListaStudenti();
			//Graphs.addAllVertices(graph, dao.ListaStudenti()) ;
			
			for(Corso c: corsi){
				System.out.println(m.get(c.getCodins()));
				graph.addVertex((m.get(c.getCodins()).getC()));
				for( Studente s: m.get(c.getCodins()).getS()){
					graph.addVertex(s);
					graph.addEdge(c, s);
				}
			}
			
			
		}
		
	}
	
	public Set<Nodo> getAllNodi(){
		this.creaGrafo();
		return graph.vertexSet();
	}

}
