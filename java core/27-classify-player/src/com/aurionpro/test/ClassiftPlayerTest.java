package com.aurionpro.test;

import com.aurionpro.model.Player;

import com.aurionpro.model.ClassifyPlayer;

public class ClassiftPlayerTest {
	public static void main(String[] args) {
        Player[] players = {
        		new Player(1, "Sachin", 200, 50000, 500),
                new Player(2, "Akash", 1, 7000, 2),
                new Player(3, "Rohit", 8, 3500, 8),
                new Player(4, "Yash", 250, 2000, 0),
                new Player(5, "Nitesh", 20, 100, 10)
        };
        ClassifyPlayer obj = new ClassifyPlayer();
        Player [] AListers= obj.getAlistPlayers(players);
        printPlayers(AListers);
//        for(Player p: AListers) {
//        	System.out.println(p);
//        } 
        
        System.out.println("=====================================================");
        
        ClassifyPlayer obj2 = new ClassifyPlayer();
        Player [] BListers= obj2.getAlistPlayers(players);
        printPlayers(BListers);
//        for(Player p: BListers) {
//        	System.out.println(p);
//        } 
        
        System.out.println("=====================================================");
        
        ClassifyPlayer obj3 = new ClassifyPlayer();
        Player [] CListers= obj3.getAlistPlayers(players);
        printPlayers(CListers);
//        for(Player p: BListers) {
//        	System.out.println(p);
//    }
   
}
	private static void printPlayers(Player[] aListers) { 
	  for(Player p:aListers) {   
		  System.out.println(p);
	  } 
	 }
	}