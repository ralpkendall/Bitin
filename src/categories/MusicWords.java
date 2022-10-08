package categories;

public class MusicWords extends Words {

    public MusicWords() {
        setWordBank();
        chooseRandomPhrase();
        setCategory("Musika");
    }

    @Override
    public void setWordBank() {
        String[] wordBank = {
                "Lupang Hinirang",
                "Regine Velasquez",
                "Silent Sanctuary",
                "Eraserheads",
                "MYMP",
                "Maldita - Porque",
                "Mayonnaise - Tayo na Lang Dalawa",
                "Kamikazee - Huling Sayaw",
                "Morissette Amon",
                "Yeng Constantino",
                "Arthur Nery",
                "Nobita - Ikaw Lang"
        };

        super.setWordBank(wordBank);
    }
}
