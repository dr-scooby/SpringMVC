/**
 * Alien Model object
 */
package com.jah.springmvcboot.model;

/**
 * 
 */
public class Alien {

	private int aid; // alien ID
	private String name;
	
	
	public Alien() {
		aid = 0;
		name = "Alien";
	}
	
	
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
