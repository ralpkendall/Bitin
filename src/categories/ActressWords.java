package categories;

public class ActressWords extends Words{

    public ActressWords() {
        setWordBank();
        chooseRandomPhrase();
        setCategory("Aktres");
    }

    @Override
    public void setWordBank() {
        String[] wordBank = {
                "Kathryn Bernardo",
                "Angel Locsin",
                "Liza Soberano",
                "Marian Rivera",
                "Nadine Lustre",
                "Anne Curtis",
                "Carla Abellana",
                "Bianca Umali",
                "Belle Mariano",
                "Maja Salvador",
                "Bea Alonzo",
                "Kim Chiu"
        };

        super.setWordBank(wordBank);
    }
}
