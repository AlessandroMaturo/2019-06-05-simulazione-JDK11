package it.polito.tdp.crimes.model;

public class DistrettoCoordinate {
	
	private Integer id;
	private double lon;
	private double lat;
	
	public DistrettoCoordinate(Integer id, double lon, double lat) {
		super();
		this.id = id;
		this.lon = lon;
		this.lat = lat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getLongitudine() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLatitudine() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
	
	
	

}
