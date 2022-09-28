package categories;

public class Proverbs extends Words{


    public Proverbs() {
        setWordBank();
        chooseRandomPhrase();
        setCategory("Kasabihan");
    }


    public void setWordBank() {
        String[] wordBank = {
                "Biruin mo ang lasing wag lang ang bagong gising",
                "Kung ano ang puno, siya rin ang bunga",
                "Ang palay ay parisan, habang nagkakalaman ay lalong nagpugpugay",
                "Ang taong nagigipit, sa patalim kumakapit",
                "Ang taong walang kibo, nasa loob ang kulo",
        };

        super.setWordBank(wordBank);
    }


}
