public class SuggestedTeam {
    private Team suggestion;
    private Team solution;
    private int numGood;
    private int numWrongSpot;

    // Public constructor that takes two Team arguments
    public SuggestedTeam(Team suggestion, Team solution) {
        this.suggestion = suggestion;
        this.solution = solution;
        this.numGood = 0;
        this.numWrongSpot = 0;
        calculateScore();
    }

    // Private method to calculate the score
    private void calculateScore() {
        for (int i = 0; i < Team.teamsize; i++) {
            if (suggestion.getPlayer(i) == solution.getPlayer(i)) {
                numGood++;
            } else if (solution.containsPlayer(suggestion.getPlayer(i))) {
                numWrongSpot++;
            }
        }
    }

    // Public getter method to return the suggested Team
    public Team getTeam() {
        return suggestion;
    }

    // Public getter method to return the number of correctly positioned players
    public int getNumGood() {
        return numGood;
    }

    // Public getter method to return the number of players in the wrong position
    public int getNumWrongSpot() {
        return numWrongSpot;
    }

    // Public method to check if the suggestion fully matches the solution
    public boolean isCorrect() {
        return numGood == Team.teamsize && numWrongSpot == 0;
    }

    // Public toString method to return a formatted string representation
    public String toString() {
        return suggestion.toString() + " (Good " + numGood + ", Wrong spot " + numWrongSpot + ")";
    }
}

