package com.gamingroom;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator; // for use of Iterator pattern

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author blake.condrey@snhu.edu
 *
 */
public class Team extends Entity {
	
	// players list per UML doc
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}

	// addPlayer method per UML
	public Player addPlayer(String name) {
		Player player = null;
		
		// validation using Iterator pattern
		
		Iterator<Player> playersIterator = players.iterator();
		
		// Iterate through list of players until complete
		
		while (playersIterator.hasNext()) {
			
			// local players instance to point to next player in list
			Player instanceOfPlayer = playersIterator.next();
			
			// condition -> check if player exists
			if (instanceOfPlayer.getName().equalsIgnoreCase(name)) {
				// truthy? return instance
				return instanceOfPlayer;
			}
		}
		
		// if not found, create new game service and player instance add to list of players
		
		if (player == null) {
			
			// new GameService
			GameService newService = GameService.getInstance();
			
			// reference for newService instance, invoke getNextPlayerId()
			player = new Player(newService.getNextPlayerId(), name);
			
			// push to players list
			players.add(player);
		}
		
		// return player instance
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
