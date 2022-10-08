package categories;

public class SportsWords extends Words {

    public SportsWords() {
        setWordBank();
        chooseRandomPhrase();
        setCategory("Isports");
    }

    @Override
    public void setWordBank() {
        String[] wordBank = {
                "Manny Pacquiao",
                "Sepak Takraw",
                "Philippine Sports Arena",
                "Inilampaso",
                "Binasura",
                "Alyssa Valdez",
                "Hidilyn Diaz",
                "Bola",
                "Paeng Nepomuceno",
                "Efren Reyes",
                "Philippine Basketball Association",
                "Premier Volleyball League"
        };

        super.setWordBank(wordBank);
    }
}
