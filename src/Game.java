import categories.Words;
import categories.WordsFactory;

import java.util.Scanner;

public class Game {
    private GameChecker gameChecker;
    private Scanner scanner;
    private boolean isGameOver;

    public Game() {
        scanner = new Scanner(System.in);

        System.out.println("Maligayang Pagdating sa Bitin: A Hangman Word Game!\n");
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
        System.out.println("Ano ang iyong ngalan, kapatid?");
        String playerName = scanner.nextLine();

        return playerName;
    }

    public Words selectPhraseCategory() {
        System.out.println("- - - - - - - - - -");
        System.out.println("MGA KATEGORYA\n");
        WordsFactory wordsFactory = new WordsFactory();
        for(int i = 0;i < wordsFactory.CATEGORY_LIST.length;i++) {
            System.out.println((i + 1) +".) "  + wordsFactory.CATEGORY_LIST[i]);
        }

        int playerCategory;
        while(true) {
            try {
                System.out.print("Pili ka ng kategorya na huhulaan: ");
//                playerCategory = scanner.nextInt();scanner.nextLine();
                playerCategory = Integer.parseInt(String.valueOf(scanner.nextLine().charAt(0)));
                if(playerCategory >= 1 && playerCategory <= wordsFactory.CATEGORY_LIST.length) {
                    break;
                }else {
                    throw new Exception();
                }
            }catch(Exception e) {
                playerCategory = 0;
                System.out.println("Pagkakamali: Hindi Wasto ang iyong Input\n");
            }
        }

        Words selectedWords = wordsFactory.getWord(playerCategory);
        String upperCasePhrase = selectedWords.getPhrase().toUpperCase();
        selectedWords.setPhrase(upperCasePhrase);

        return selectedWords;
    }

    public void start() {

        while (!isGameOver){
            System.out.println("- - - - - - - - - -");
            gameChecker.printHangman();
            System.out.println("\nHinuhulaang Mga Kataga: ");
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
            System.out.println("Ang talino mo!");
            System.out.println("Hinuhulaang Mga Kataga: " + words.getPhrase());
        } else{
            gameChecker.printHangman();
            System.out.println("Tapos ka na, " + player.getName() + ".");
            System.out.println("Aral tayo ulit, kapatid.");
            System.out.println("Hinuhulaang Mga Kataga: " + words.getPhrase());
        }
    }

}
