package it.polito.tdp.simulator;

import java.util.PriorityQueue;

import it.polito.tdp.crimes.db.EventsDao;
import it.polito.tdp.crimes.model.Event;

public class Simulatore {
	
	private EventsDao dao;
	
	// Parametri in ingresso
	private int numAgenti;
	
	// Valori calcolati in uscita
	private int cntGestitiMale;
	
	// Stato del mondo
	
	// Coda degli eventi
	private PriorityQueue<Event> queue;
	
	public Simulatore(int agenti, int anno, int mese, int giorno) {
		dao = new EventsDao();
		
		String distrettoMinorCriminalita = dao.getDistrettoMinorCriminalita(anno, mese, giorno);
		
		this.cntGestitiMale=0;
	
	}
	
	

}
