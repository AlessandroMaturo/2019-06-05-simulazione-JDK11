package it.polito.tdp.crimes.model;

public class DistrettoDistanza {

	private Integer id;
	private double distanza;
	
	public DistrettoDistanza(Integer id, double distanza) {
		super();
		this.id = id;
		this.distanza = distanza;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getDistanza() {
		return distanza;
	}

	public void setDistanza(double distanza) {
		this.distanza = distanza;
	}
	
	
	
}
