public class Player {

    private String name;
    private char guess;
    private int strike;
    private boolean hasWin;

    public Player(String name) {
        this.name = name;
        this.guess = 0;
        this.strike = 0;
        this.hasWin = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGuess() {
        return guess;
    }

    public void setGuess(char guess) {
        this.guess = guess;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public boolean isHasWin() {
        return hasWin;
    }

    public void setHasWin(boolean hasWin) {
        this.hasWin = hasWin;
    }
}
