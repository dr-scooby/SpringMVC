/**
 * Alien Model object
 */
package com.jah.springmvcboot.model;

/**
 * The Bean, Alien
 */
public class Alien {

	private int aid; // alien ID
	private String name;
	
	// default Constructor
	public Alien() {
		aid = 0;
		name = "Alien";
	}
	
	
	
	// take ID and Name
	public Alien(int aid, String name) {
		super();
		this.aid = aid;
		this.name = name;
	}




	/* --- Get and Set Methods ---  */
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", name=" + name + "]";
	}
	
	
	
}
