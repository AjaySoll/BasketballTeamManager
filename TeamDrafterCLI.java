import java.util.Scanner;

public class TeamDrafterCLI {
    public static void main(String[] args) {
        TeamDrafter teamDrafter = new TeamDrafter();
        playGame(teamDrafter);
    }

    public static void playGame(TeamDrafter teamDrafter) {
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            // Displays previous attempts
            System.out.println("Previous attempts:");
            TeamDrafter.Node previousSuggestions = teamDrafter.getPreviousSuggestions();
            if (previousSuggestions == null) {
                System.out.println("No previous attempts");
            } else {
                System.out.println(previousSuggestions.toString() + "\n");
            }
    
            // Asks the user to enter a new team
            System.out.println("Enter new team:");
            int[] playerNumbers = readPlayerNumbers(scanner);
    
            // Checks if the suggested team is correct
            Team userTeam = new Team(playerNumbers);
            boolean isCorrect = teamDrafter.checkSuggestedTeam(userTeam);
    
            if (isCorrect) {
                // Displays the final team
                System.out.println("The final team is:");
                printTeamNames(playerNumbers);
                break;
            } else {
                System.out.println("Invalid team!");
            }
        }
    
        scanner.close();
    }

    
    private static int[] readPlayerNumbers(Scanner scanner) {
        // creates an array to store the jersey numbers 
        int[] playerNumbers = new int[Team.teamsize];
        //loops through each position in the team and stops when it hits the team size
        for (int i = 0; i < Team.teamsize; i++) {
            playerNumbers[i] = scanner.nextInt();
        }
        //returns the array of player jersey number 
        return playerNumbers;
    }

    // this gets the player names and numbers 
    private static void printTeamNames(int[] playerNumbers) {
        for (int number : playerNumbers) {
            System.out.println("Name for number " + number + ": " + Team.getPlayerName(number));
        }
    }
}