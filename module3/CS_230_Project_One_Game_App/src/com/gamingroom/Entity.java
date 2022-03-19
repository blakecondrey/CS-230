package com.gamingroom;

/**
 * A simple class for required attributes
 * from UML Diagram provided in resources
 * 
 * @author blake.condrey@snhu.edu
 *
 */

public class Entity {

	protected long id; // UML lists as private, NOT accessible in game unless 'protected'
	
	protected String name; // UML lists as private, NOT accessible in game unless 'protected'
	
	protected Entity() {} // UML lists as private, NOT accessible in game unless 'protected'
	
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	// following convention used in provided classes for toString() method
	@Override
	public String toString() {
		// String interpolation using String.format()
		return "Entity [id = " + id + ", name = " + name + "]";
	}
}
