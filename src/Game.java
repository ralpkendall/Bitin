import categories.Words;

public class Game {

    private Player player;
    private Words words;
    private BoardChecker boardChecker;

    public Game() {
        createPlayer();
        selectPhraseCategory();
        createBoard();
    }

    private void createPlayer() {
        System.out.println("What's your name, bud?");
        String playerName = Board.scanner.nextLine();
        this.player = new Player(playerName);
    }

    private void selectPhraseCategory() {

    }

    private void createBoard() {
    }
}
