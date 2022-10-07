package categories;

public abstract class Words {

    private String[] wordBank;
    private String phrase;
    private String category;

    public void chooseRandomPhrase(){
        int MAX = wordBank.length - 1;
        int MIN = 0;
        int randomNum = (int) ((Math.random() * (MAX - MIN)) + 1);

        setPhrase(getWordBank()[randomNum]);
    }

    public String[] getWordBank() {
        return wordBank;
    }

    public void setWordBank(String[] wordBank) {
        this.wordBank = wordBank;
    }

    abstract public void setWordBank();

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        category = category;
    }
}
