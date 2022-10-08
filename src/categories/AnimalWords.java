package categories;


public class AnimalWords extends Words {

    public AnimalWords() {
        setWordBank();
        chooseRandomPhrase();
        setCategory("Hayop");
    }

    @Override
    public void setWordBank() {
        String[] wordBank = {
                "Tigre",
                "Baboy",
                "Alimasag",
                "Balyena",
                "Bulati",
                "Palaka",
                "Gorilya",
                "Kabayo",
                "Kuneho",
                "Buwaya",
                "Kuwago",
                "Butiki"
        };

        super.setWordBank(wordBank);
    }
}
