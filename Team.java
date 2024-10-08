public class Team {
    public static final int teamsize = 5;
    private int[] players;

    // Public constructor that takes a single int[] argument to initialize the team
    public Team(int[] players) {
        this.players = players;
    }

    // Public method to get the player at position i in the team
    public int getPlayer(int i) {
        return players[i];
    }

    // Method to check if the team contains a specific player
    public boolean containsPlayer(int player) {
        for (int p : players) {
            if (p == player) {
                return true;
            }
        }
        return false;
    }

    // to string method that returns the sequence of players seperated by spaces
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players.length; i++) {
            sb.append(players[i]);
            if (i < players.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String getPlayerName(int playerNumber) {
        String[] playerNames = {"Player1", "Player2", "Player3", "Player4", "Player5"};
        if (playerNumber >= 1 && playerNumber <= 5) {
            return playerNames[playerNumber - 1];
        } else {
            return "Unknown";
        }
    }
}