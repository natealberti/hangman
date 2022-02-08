import java.util.Arrays;

public class game {

    int lives;
    int difficulty;
    String solution;
    String[] solutionArray;
    String[] currentState;

    public game(int difficulty) {
        this.difficulty = difficulty;
        this.lives = 5;
    }

    // generate the solution and assign it to the data members
    public void generateSolution() {
        wordBank bank = new wordBank(difficulty);
        solution = bank.getWord();

        // getting the arrays set up
        solutionArray = solution.split("");
        currentState = solution.split("");

        // setting currentState to be the word with just underscores
        Arrays.fill(currentState, "_");
    }

    // make a guess and change the initial state if guess is correct
    // otherwise return initial state and subtract a life
    public void guess(String letter) {
        boolean correctGuess = false;

        // checking if each letter in solution matches the guess
        for(int i = 0; i < solutionArray.length; i++) {
            if(solutionArray[i].equalsIgnoreCase(letter)) {
                correctGuess = true;
                currentState[i] = letter;
            }
        }

        // if the wrong answer
        if(!correctGuess) {
            if(lives==0) {
                endGame();
            }
            else {
                lives--;
                System.out.println("wrong! you lost a life. you have " + lives + " lives remaining.\n");
            }
        }

        // if the word is revealed
        if(printCurrentState().equalsIgnoreCase(printSolutionArray())) {
            System.out.println("congrats! you won the game. the word was >" + solution + "<");
        }
    }

    public String printCurrentState() {
        String r = "";
        for (String s : currentState) {
            r = r.concat(s);
        }
        return r;
    }

    private String printSolutionArray() {
        String r = "";
        for (String s : solutionArray) {
            r = r.concat(s);
        }
        return r;
    }

    public boolean checkIfWon() {
        return printCurrentState().equalsIgnoreCase(printSolutionArray());
    }

    private void endGame() {

        System.out.println("\n\n--- the game ended, you lost ---");
        System.out.println("the solution was >" + solution + "<");

    }

}
