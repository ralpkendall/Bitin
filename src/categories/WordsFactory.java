package categories;

public class WordsFactory {

    public final String[] CATEGORY_LIST = {
        "Kasabihan",
        "Aktor",
    };

    public Words getWord(int choiceNum) {
        if(choiceNum == 1){
            return new SayingsWords();
        }
        if(choiceNum == 2){
            return new ActorWords();
        }

        return null;
    }
}
