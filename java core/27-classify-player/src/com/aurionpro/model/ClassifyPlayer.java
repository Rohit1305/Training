package com.aurionpro.model;

public class ClassifyPlayer {
	
	public Player[] getAlistPlayers(Player[] player) {
		int count=0;
		
		for(Player p:player) {
			if(p.getMatches()>100 && (p.getRuns()>5000 || p.getWickets()>150)) {
				count++;
			}
		}
		
		Player[]AListers = new Player[count];
	    for (int i =0, j=0; i<player.length; i++) {
	    	if(player[i].getMatches()>100 && (player[i].getRuns()>5000 || player[i].getWickets()>150)) {
	    		AListers[j++]=player[i];
	    	}
	    }
	    return AListers;
	}
	
	
	public Player[] getBlistPlayers(Player[] player) {
		int count=0;
		
		for(Player p:player) {
			if(p.getMatches()>15 && (p.getRuns()>3000 || p.getWickets()>75)) {
				count++;
			}
		}
		
		Player[]BListers = new Player[count];
	    for (int i =0, j=0; i<player.length; i++) {
	    	if(player[i].getMatches()>15 && (player[i].getRuns()>3000 || player[i].getWickets()>75)) {
	    		BListers[j++]=player[i];
	    	}
	    }
	    return BListers;
	        
	}
	public Player[] getCListers(Player[] players) {
		int count = 0;

		for (Player p : players) {
			if  (p.getMatches() <=50 && (p.getRuns() <=3000 || p.getWickets() <=75)) {
				count++;
			}
		}
//		System.out.println(count);
		Player[] cListers = new Player[count];

		for (int i = 0, j = 0; i < players.length; i++) {
			if ((players[i].getMatches()<=  50 )
					&& ((players[i].getRuns() <=3000 )
							|| (players[i].getWickets()<=  75 ))) {
				cListers[j++] = players[i];
			}
		}
		
		return cListers;
	}

}
