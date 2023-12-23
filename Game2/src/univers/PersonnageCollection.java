package univers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonnageCollection {
	
	    private List<Player> players;
	    private Map<String, Player> playerMap;

	    public PersonnageCollection() {
	        this.players = new ArrayList<>();
	        this.playerMap = new HashMap<>();
	    }

	    public void addPlayer(Player player) {
	        players.add(player);
	        playerMap.put(player.getNom(), player);
	    }

	    public List<Player> getPlayers() {
	        return players;
	    }

	    public Player getPlayerByName(String name) {
	        return playerMap.get(name);
	    }




}
