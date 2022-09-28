package categories;

public class Actor extends Words {

    public Actor() {
        setWordBank();
        chooseRandomPhrase();
        setCategory("Aktor");
    }

    @Override
    public void setWordBank() {
        String[] wordBank = {
                "James Reid",
                "Daniel Padilla",
                "Joshua Garcia",
                "Paulo Avelino",
                "Robin Padilla",
        };

        super.setWordBank(wordBank);
    }
}
