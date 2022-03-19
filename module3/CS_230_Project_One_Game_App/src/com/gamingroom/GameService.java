package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator; // for use of Iterator pattern

/**
 * A singleton service for the game engine
 * 
 * @author blake.condrey@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	private static long nextTeamId = 1;
	
	private static long nextPlayerId = 1;
	
	private static GameService service = new GameService();
	
	/*
	 * make the default constructor private so that this class cannot be instantiated
	 */
	
	private GameService() {}
	
	/*
	 * Get the only object available
	 */
	
	public static GameService getInstance() {
		return service;
	}
	
	/*
	 * Singleton Pattern completed. A single class (GameService) is responsible to 
	 * create a single, private object of itself, negating the need to instantiate
	 * an object of the class 
	 */


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		
		// Begin validation using Iterator pattern

		Iterator<Game> gamesIterator = games.iterator();
		
		// iterate through list of games until complete, until = while-loop
		
		while (gamesIterator.hasNext()) { // hasNext() checks if next item in list exists
			
			// local game instance variable to point to next game in games list
			Game instanceOfGame = gamesIterator.next();
			
			// condition: check IF game exists
			if (instanceOfGame.getName().equalsIgnoreCase(name)) {
				// truthy? return instance
				return instanceOfGame;
			}
		}
		
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		
		// Begin validation using Iterator pattern
		
		Iterator<Game> gamesIterator = games.iterator();
		
		// iterate through list of games until complete, until = while-loop
		
		while (gamesIterator.hasNext()) { // hasNext() checks if next item in list exists
			
			/// local game instance variable to point to next game in games list
			Game instanceOfGame = gamesIterator.next();
			
			// condition: check IF game id exists
			if (instanceOfGame.getId() == id) { // strict equality to find matching id
				// truthy? return game
				return instanceOfGame;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		
		// Begin validation using Iterator pattern
		Iterator<Game> gamesIterator = games.iterator();
		
		// iterate through list of games until complete, until = while-loop
		while (gamesIterator.hasNext()) { // hasNext() checks if next item in list exists
			
			// local game instance variable to point to next game in games list
			Game instanceOfGame = gamesIterator.next();
			
			// condition: check IF game name exists
			if (instanceOfGame.getName().equalsIgnoreCase(name)) {
				// truthy? return game
				return instanceOfGame;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	public long getNextTeamId() {
		return nextTeamId++;
	}
	
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
}
