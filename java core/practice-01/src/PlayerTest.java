import javax.swing.text.StyledEditorKit.ForegroundAction;

public class PlayerTest {

	public static void main(String[] args) {
		
		
		Player[] player = {
				new Player("john",30,CountryType.INDIA,1803,5,2),
				new Player("elbert",32,CountryType.INDIA,2019,7,3),
				new Player("leo",34,CountryType.AUSTRALIA,3553,10,5),
				new Player("colt",26,CountryType.SRILANKA,2389,6,3),
				new Player("root",31,CountryType.AUSTRALIA,2719,8,2),
				new Player("stuart",30,CountryType.SRILANKA,1890,4,2),
				new Player("joe",29,CountryType.AFRICA,2556,7,1),
				new Player("jay",34,CountryType.INDIA,3803,9,4),
				new Player("stokes",29,CountryType.AFRICA,3779,7,2),
				new Player("ben",28,CountryType.AUSTRALIA,1443,5,4),
				new Player("belt",30,CountryType.AFRICA,4556,5,2),
				new Player("edson",30,CountryType.SRILANKA,6503,11,7),};
		
		Player[] countries = Player.class.getEnumConstants();
		
		System.out.println("player with highestruns"+playerhighestruns(player));
		 System.out.println("playerwithlowest runs"+playerlowestruns(player));
		 System.out.println("playerwithhighest fifties"+playerhighestfifties(player));
		 System.out.println("playerwithhighest hundreds"+playerhighesthundreds(player));
		 System.out.println("youngerplayer"+playeryoungest(player));
		 System.out.println("oldestplayer"+playeroldest(player));
		 System.out.println("Countries:"+countries);
		 for (int i = 0; i < countries.length; i++) {
			 Player players = 
		}
	}
		
		
		private static Player playerhighestruns(Player[] player) {
		 Player maxPlayer = player[0];
		 for (int i = 1; i < player.length; i++) {
		  if(player[i].getRunscored() > maxPlayer.getRunscored()) {
		   maxPlayer = player[i];
		  }
		 }
		 return maxPlayer;
		}

		private static Player playerlowestruns(Player[] player) {
		 Player minPlayer = player[0];
		 for (int i = 0; i < player.length; i++) {
		  if(player[i].getRunscored()<minPlayer.getRunscored()) {
		   minPlayer=player[i];
		  }
		 }
		 
		 return minPlayer;
		 }
		private static Player playerhighestfifties(Player[] player) {
		 Player maxfifties = player[0];
		 for (int i = 1; i < player.length; i++) {
		  if(player[i].getFifties() > maxfifties.getFifties()) {
		   maxfifties = player[i];
		  }
		 }
		 return maxfifties;
		}
		private static Player playerhighesthundreds(Player[] player) {
		 Player maxhundreds = player[0];
		 for (int i = 1; i < player.length; i++) {
		  if(player[i].getHundreds() > maxhundreds.getHundreds()) {
		   maxhundreds = player[i];
		  }
		 }
		 return maxhundreds;
		}
		private static Player playeryoungest(Player[] player) {
		 Player youngest = player[0];
		 for (int i = 0; i < player.length; i++) {
		  if(player[i].getAge() < youngest.getAge()) {
		   youngest = player[i];
		  }
		 }
		 return youngest;
		 
		}
		private static Player playeroldest(Player[] player) {
		 Player oldest = player[0];
		 for (int i = 0; i < player.length; i++) {
		  if(player[i].getAge() > oldest.getAge()) {
		   oldest = player[i];
		  }
		 }
		 return oldest;
		 
		 
	}

	

}
