package it.polito.tdp.crimes.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	
	private EventsDao dao;
	private Graph<Integer, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new EventsDao();
	}
	
	
	public void creaGrafo(int year) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, dao.getVertexes());
		
		List<DistrettoCoordinate> coordinateMedie = dao.getDistrettiCoordinateMedie(year);
		
		for(Integer i1: grafo.vertexSet()) {
			for(Integer i2: grafo.vertexSet()) {
				if(i1!=i2 && !grafo.containsEdge(i2, i1)) {
					
					LatLng c1=new LatLng(getLat(coordinateMedie, i1), getLon(coordinateMedie,i1));
					LatLng c2=new LatLng(getLat(coordinateMedie, i2), getLon(coordinateMedie,i2));
					
					double peso=LatLngTool.distance(c1, c2, LengthUnit.KILOMETER);
					
					Graphs.addEdge(this.grafo, i1, i2, peso);
				}
			}
		}
	}
	
	public List<Integer> getDistinctYear(){
		return this.dao.getDistinctYear();
	}
	
	public double getLat(List<DistrettoCoordinate> coordinateMedie, int id) {
		
		double lat=0.0;
		
		for(DistrettoCoordinate di: coordinateMedie) {
			if(di.getId()==id) {
				lat = di.getLatitudine();
			}
		}
				
		return lat;
		
	}
	
	public double getLon(List<DistrettoCoordinate> coordinateMedie, int id) {
		
		double lon=0.0;
		
		for(DistrettoCoordinate di: coordinateMedie) {
			if(di.getId()==id) {
				lon = di.getLongitudine();
			}
		}
				
		return lon;
		
	}
	
	public List<DistrettoDistanza> getAdiacenti(int distretto){
		
		List<DistrettoDistanza> result = new LinkedList<>();
		
		
		List<Integer> vicini = Graphs.neighborListOf(this.grafo, distretto);
		
		for(Integer ii: vicini) {
			if(ii!=distretto) {
				result.add(new DistrettoDistanza(ii, this.grafo.getEdgeWeight(this.grafo.getEdge(ii, distretto))));				
			}
		}
		
		
		return result;
	}
	
	public Set<Integer> getVertexes(){
		return this.grafo.vertexSet();
	}
	
}
