package categories;

public class SayingsWords extends Words{

    public SayingsWords() {
        setWordBank();
        chooseRandomPhrase();
        setCategory("Kasabihan");
    }


    public void setWordBank() {
        String[] wordBank = {
                "Ang hindi marunong lumingon sa pinanggalingan ay hindi makararating sa paroroonan",
                "Walang mahirap na gawa 'pag dinaan sa tiyaga",
                "Ang kaginhawaan ay nasa kasiyahan, at wala sa kasaganahan",
                "Ang tunay na pag-ibig sa bayan ay nasa pawis ng gawa",
                "Nasa Diyos ang awa, nasa tao ang gawa",
                "Kung walang tiyaga, walang nilaga",
                "Habang maikli ang kumot, matutong mamaluktot",
                "Kapag apaw na ang takalan, kailangan kalusan",
                "Kung may isinuksok, may madudukot",
                "Huwag kang magtiwala sa ‘di mo kakilala",
                "Kuwarta na, naging bato pa",
                "Ang isip ay parang itak, sa hasa tumatalas",

        };

        super.setWordBank(wordBank);
    }


}
