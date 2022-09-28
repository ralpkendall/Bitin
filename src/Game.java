import categories.Words;
import categories.WordsFactory;

import java.util.Scanner;

public class Game {
    private GameChecker gameChecker;
    private Scanner scanner;
    private boolean isGameOver;

    public Game() {
        scanner = new Scanner(System.in);

        Player player = createPlayer();
        Words words = selectPhraseCategory();
        gameChecker = new GameChecker(player, words);
        start();

    }

    public Player createPlayer() {
        String playerName = inputPlayerName();

        return new Player(playerName);
    }

    private String inputPlayerName(){
        System.out.println("Pangalan mo po?");
        String playerName = scanner.nextLine();

        return playerName;
    }

    public Words selectPhraseCategory() {
        System.out.println("- - - - - - - - - -");
        WordsFactory wordsFactory = new WordsFactory();
        for(int i = 0;i < wordsFactory.CATEGORY_LIST.length;i++) {
            System.out.println((i + 1) +".) "  + wordsFactory.CATEGORY_LIST[i]);
        }
        System.out.print("Pili ka ng ikamamatay mo: ");
        int playerCategory = scanner.nextInt();scanner.nextLine();

        Words selectedWords = wordsFactory.getWord(playerCategory);
        String upperCasePhrase = selectedWords.getPhrase().toUpperCase();
        selectedWords.setPhrase(upperCasePhrase);

        return selectedWords;
    }

    public void start() {

        while (!isGameOver){
            System.out.println("- - - - - - - - - -");
            gameChecker.printHangman();
            System.out.println(gameChecker.getHiddenPhrase() + "\n");
            System.out.print("Hula ka ng isang letra:");
            char inputGuess = scanner.next().charAt(0);scanner.nextLine();
            inputGuess = Character.toUpperCase(inputGuess);
            gameChecker.getPlayer().setGuess(inputGuess);
            gameChecker.processGuess();
            isGameOver = gameChecker.isGameOver();
        }

        showResults();

    }

    public void showResults(){
        Player player = gameChecker.getPlayer();
        Words words = gameChecker.getWords();

        if(player.isHasWin()){
            System.out.println("Congrats, " + player.getName() + "!");
            System.out.println("Talino mo talaga!");
            System.out.println("Hinuhulaang Parirala: " + words.getPhrase());
        } else{
            gameChecker.printHangman();
            System.out.println("Tapos ka na, " + player.getName() + ".");
            System.out.println("Next time, pakigamit ang utak natin ahihi");
            System.out.println("Hinuhulaang Parirala: " + words.getPhrase());
        }
    }

}
