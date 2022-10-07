package categories;

public class ActorWords extends Words {

    public ActorWords() {
        setWordBank();
        chooseRandomPhrase();
        setCategory("Aktor");
    }

    @Override
    public void setWordBank() {
        String[] wordBank = {
                "Coco Martin",
                "John Lloyd Cruz",
                "Dingdong Dantes",
                "Daniel Padilla",
                "Xian Lim",
                "Eddie Garcia",
                "Piolo Pascual",
                "Tom Rodriguez",
                "Paulo Avelino",
                "James Reid",
                "Derek Ramsay",
                "Carlo Aquino"
        };

        super.setWordBank(wordBank);
    }
}
