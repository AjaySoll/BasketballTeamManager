import java.util.Random;

public class TeamDrafter {
    private static final int teamsize = 5; 
    private static final int minplayer = 1;
    private static final int maxplayer = 9;

    private Team solution;

    private Node head; // Head of the linked list

    // Public constructor that takes a single Team argument as the game solution
    public TeamDrafter(Team solution) {
        this.solution = solution;
        this.head = null;
    }

    // Public constructor that generates a random solution
    public TeamDrafter() {
        this.solution = generateRandomSolution();
        this.head = null;
    }

    // Private method to generate a random solution
    private Team generateRandomSolution() {
        Random random = new Random();
        int[] randomPlayers = new int[teamsize];
        boolean[] usedPlayers = new boolean[maxplayer + 1];

        for (int i = 0; i < teamsize; i++) {
            int player;
            do {
                player = random.nextInt(maxplayer - minplayer + 1) + minplayer;
            } while (usedPlayers[player]);

            randomPlayers[i] = player;
            usedPlayers[player] = true;
        }

        return new Team(randomPlayers);
    }

    // Public method to check a suggested team and store it in the linked list
    public boolean checkSuggestedTeam(Team team) {
        SuggestedTeam suggestedTeam = new SuggestedTeam(team, solution);
        Node newNode = new Node(suggestedTeam);
        newNode.next = head; // Add the new node at the head of the list
        head = newNode;

        // Return true if the suggested team matches the solution, false otherwise
        return suggestedTeam.isCorrect();
    }

    // Public getter method to return the head of the list of previous draft teams
    public Node getPreviousSuggestions() {
        return head;
    }

    // Public getter method to return the game solution
    public Team getSolution() {
        return solution;
    }

    // Nested Node class for linked list implementation
    public static class Node {
        private SuggestedTeam data;
        private Node next;

        public Node(SuggestedTeam data) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            Node current = this;
            while (current != null) {
                result.append(current.data.toString()).append("\n");
                current = current.next;
            }
            return result.toString();
        }
    }
}

