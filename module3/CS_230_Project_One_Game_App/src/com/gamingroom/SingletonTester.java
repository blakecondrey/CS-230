package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author blake.condrey@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		// FIXME: obtain local reference to the singleton instance
		/*
		 * Code validates single instance of GameService created by invoking
		 * the getInstance() method
		 */
		GameService service = GameService.getInstance(); // replace null with ??? -> getInstance();
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}
