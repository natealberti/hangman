import java.util.Scanner;

public class run {

    // System.out.println();
    public static void main(String[] args) {

        // program setup
        System.out.println("---hangman---");
        System.out.println("select a difficulty (1 = easy, 2 = medium, 3 = hard): ");
        Scanner scan = new Scanner(System.in);
        int diff = scan.nextInt();
        System.out.println("\n\n");

        // game setup
        game game = new game(diff);
        game.generateSolution();

        while(game.lives > 0 && !game.checkIfWon()) {
            System.out.println("your word: " + game.printCurrentState());
            System.out.println("lives remaining: " + game.lives + "\n");

            System.out.println("make a one character guess: ");
            String guess = scan.next();
            game.guess(guess);

        }


    }

}
