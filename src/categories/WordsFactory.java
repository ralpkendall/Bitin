package categories;
public class WordsFactory {

    public final String[] CATEGORY_LIST = {
            "Kasabihan",
            "Aktor",
            "Aktres",
            "Isports",
            "Musika",
            "Hayop"
    };

    public Words getWord(int choiceNum) {
        if(choiceNum == 1){
            return new SayingsWords();
        }
        if(choiceNum == 2){
            return new ActorWords();
        }
        if(choiceNum == 3){
            return new ActressWords();
        }
        if(choiceNum == 4){
            return new SportsWords();
        }
        if(choiceNum == 5){
            return new MusicWords();
        }
        if(choiceNum == 6){
            return new AnimalWords();
        }

        return null;
    }
}
