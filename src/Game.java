import categories.Words;
import categories.WordsFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private GameChecker gameChecker;
    private Scanner scanner;
    private boolean isGameOver;

    public Game() {
        scanner = new Scanner(System.in);

        System.out.println("Maligayang Pagdating sa Bitin: A Hangman Word Game!");
        int gameMode = selectGameMode();
        if(gameMode == 1) {
           singlePlayerGame();
        }else if(gameMode == 2){
            twoPlayerGame();
        }


    }

    public int selectGameMode() {
        int gameModeSelected = 0;
        while(gameModeSelected != 1 && gameModeSelected != 2) {
            try{
                System.out.println("[1] Single Player");
                System.out.println("[2] Two Players");
                System.out.print("Enter your choice: ");
                gameModeSelected = Integer.parseInt(scanner.nextLine());

                if (gameModeSelected != 1 && gameModeSelected != 2) {
                    throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Invalid Input!");
            }
        }


        return gameModeSelected;
    }

    public void singlePlayerGame() {
        Player player = createPlayer();
        Words words = selectPhraseCategory();
        gameChecker = new GameChecker(player, words);
        start();
    }

    public void twoPlayerGame() {

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
                String playerCategoryRaw = scanner.nextLine();
                playerCategory = Integer.parseInt(playerCategoryRaw);

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
            printHangman();
            inputPlayerGuess();
            gameChecker.processGuess();
            isGameOver = gameChecker.isGameOver();
        }

        showResults();
    }

    private void printHangman() {
        System.out.println("- - - - - - - - - -");
        gameChecker.printHangman();
        System.out.println("\nHinuhulaang Mga Kataga: ");
        System.out.println(gameChecker.getHiddenPhrase() + "\n");
    }

    public void inputPlayerGuess() {
        char inputGuess;
        while(true) {
            try {
                System.out.print("Hula ka ng isang letra:");
                String inputGuessRaw = scanner.nextLine();
                if(inputGuessRaw.length() != 1) {
                    throw new Exception();
                }

                inputGuess = inputGuessRaw.charAt(0);
                inputGuess = Character.toUpperCase(inputGuess);
                if((inputGuess >= 65 && inputGuess <= 90) || (inputGuess >= 48 && inputGuess <= 57)) {
                    if(gameChecker.hasAlreadyInputted(inputGuess)) {
                        throw new InputMismatchException();
                    }else{
                        gameChecker.addInputRecords(inputGuess);
                    }
                    break;
                }else {
                    throw new Exception();
                }
            }catch(InputMismatchException e) {
                inputGuess = 0;
                System.out.println("Pagkakamali: Ang letra na iyan ay napili mo na\n");
            }catch(Exception e) {
                inputGuess = 0;
                System.out.println("Pagkakamali: Hindi Wasto ang iyong Input\n");
            }
        }

        gameChecker.getPlayer().setGuess(inputGuess);
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
