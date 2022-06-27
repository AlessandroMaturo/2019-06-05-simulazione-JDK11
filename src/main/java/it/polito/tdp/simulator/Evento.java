package it.polito.tdp.simulator;

import java.time.LocalDateTime;

public class Evento {
	
	public enum EventType {
		AGENTE_LIBERO,
		AGENTE_OCCUPATO
	}
	
	private int distretto;
	private LocalDateTime data;
	private EventType tipo;
	private String categoria;
	
	public Evento(int distretto, LocalDateTime data, EventType tipo, String categoria) {
		super();
		this.distretto = distretto;
		this.data = data;
		this.tipo = tipo;
		this.categoria = categoria;
	}

	public int getDistretto() {
		return distretto;
	}

	public void setDistretto(int distretto) {
		this.distretto = distretto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public EventType getTipo() {
		return tipo;
	}

	public void setTipo(EventType tipo) {
		this.tipo = tipo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
