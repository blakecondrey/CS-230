package com.gamingroom;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator; // for use of Iterator pattern

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */


public class Game extends Entity { // Game now inherits from Entity
	
	private static List<Team> teams = new ArrayList<Team>();
	
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	public Team addTeam(String name) {
		
		Team team = null;
		
		// Validation using ITerator pattern
		
		Iterator<Team> teamsIterator = teams.iterator();
		
		// Iterate though list of teams until complete
		
		while (teamsIterator.hasNext()) {
			
			// local team instance variable to point to next team in list
			Team instanceOfTeam = teamsIterator.next();
			
			// condition -> check if team exists
			if (instanceOfTeam.getName().equalsIgnoreCase(name)) {
				// truthy? return instance
				return instanceOfTeam;
			}
		}
		
		// if not found, create new game service and team instance and add to list of teams
		if (team == null) {
			
			// new GameService
			GameService newService = GameService.getInstance();
			
			// reference for newService instance, invoke getNextTeamId
			team = new Team(newService.getNextTeamId(), name);
			// push to teams Team List
			teams.add(team);
		}
		
		// return the team instance
		return team;
		
	}
	
	// following convention used in provided classes for toString() method
	@Override
	public String toString() {
		return "Game [id = " + id + ", name = " + name + "]";
	}

}
