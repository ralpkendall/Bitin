import categories.Words;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameChecker{

    private final String[] HANGMAN = {
        "+---+\n" +
        "  |   |\n" +
        "      |\n" +
        "      |\n" +
        "      |\n" +
        "      |\n" +
        "=========",
        "+---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        "      |\n" +
        "      |\n" +
        "      |\n" +
        "=========",
        "+---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        "  |  |\n" +
        "      |\n" +
        "      |\n" +
        "=========",
        "+---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|\\  |\n" +
        "      |\n" +
        "      |\n" +
        "=========",
        "+---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|\\  |\n" +
        " / \\   |\n" +
        "      |\n" +
        "========="
    };
    private final int MAX_STRIKE = 4;

    private Player player;
    private Words words;
    private String hiddenPhrase;

    private ArrayList<Character> inputRecords;

    public GameChecker(Player player, Words words) {
        this.player = player;
        this.words = words;

        hiddenPhrase = convertPhraseToUnderscore(words);
        inputRecords = new ArrayList<Character>();
    }

    public void printHangman() {
        int playerStrike = player.getStrike();
        System.out.println(HANGMAN[playerStrike]);
    }

    private String convertPhraseToUnderscore(Words word) {
        String phrase = word.getPhrase();
        String underscoredPhrase = "";
        for (int i = 0; i < phrase.length();i++) {
            char letter = phrase.charAt(i);//Robin Padilla || letter =
            if(letter >= 65 && letter <= 90) {
                underscoredPhrase += "_";
            } else if(letter == 32) {
                underscoredPhrase += " ";
            } else if(letter == 44) {
                underscoredPhrase += ",";
            }
        }

        return underscoredPhrase;
    }

    public void addInputRecords(char inputGuess) {
        inputRecords.add(inputGuess);
    }



    public void processGuess() {
        String phrase = words.getPhrase();
        char guess = player.getGuess();
        boolean isGuessRight = false;

        for(int i = 0;i < phrase.length();i++) {
            if(phrase.charAt(i) == guess) {
                isGuessRight = true;

                StringBuilder stringBuilder = new StringBuilder(hiddenPhrase);
                stringBuilder.setCharAt(i,guess);
                hiddenPhrase = stringBuilder.toString();
            }
        }

        if(!isGuessRight){
            player.setStrike(player.getStrike() + 1);
        }
    }

    public boolean hasAlreadyInputted(char inputGuess) {
        boolean isAlreadyInputted = false;
        for(int i = 0;i < inputRecords.size();i++){
            if(inputGuess == inputRecords.get(i)){
                isAlreadyInputted = true;
            }
        };

        return isAlreadyInputted;
    }

    public boolean isGameOver() {
        return isPhraseSolved() || isStrikeFull();
    }

    private boolean isPhraseSolved(){
        String phrase = words.getPhrase();

        if (phrase.equals(hiddenPhrase)) {
            player.setHasWin(true);
            return true;
        }

        return false;
    }

    private boolean isStrikeFull() {
        if(player.getStrike() == MAX_STRIKE){
            player.setHasWin(false);
            return true;
        }

        return false;
    }

    public String[] getHangman() {
        return HANGMAN;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Words getWords() {
        return words;
    }

    public void setWords(Words words) {
        this.words = words;
    }

    public String getHiddenPhrase() {
        return hiddenPhrase;
    }

    public void setHiddenPhrase(String hiddenPhrase) {
        this.hiddenPhrase = hiddenPhrase;
    }

    public String[] getHANGMAN() {
        return HANGMAN;
    }

    public int getMAX_STRIKE() {
        return MAX_STRIKE;
    }

    public ArrayList<Character> getInputRecords() {
        return inputRecords;
    }

    public void setInputRecords(ArrayList<Character> inputRecords) {
        this.inputRecords = inputRecords;
    }
}
