package compulsory;
import java.util.Scanner;
import java.util.*;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running = true;
    int playerScore = 0;

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    ArrayList<String> wordsFromDictionary = new ArrayList<>();
    private final Dictionary dictionary = new Dictionary(wordsFromDictionary);

//    iterate(tiles, howMany, new char[howMany], 0);
//    static ArrayList<String> wordsList = new ArrayList<>();
    int howMany = 7;



    private void submitRandomWord() {
        List<Tile> extracted = game.getBag().extractTiles(howMany);
        if (extracted.isEmpty()) {
            running = false;
            return;
        }
//        System.out.println(wordsFromDictionary);

//        ArrayList<String> wordsGenerated = game.getBag().getWordsList();
//        System.out.println(wordsGenerated);
//        wordsFromDictionary.retainAll(wordsGenerated);

//        System.out.println(wordsFromDictionary);

//        iterate(tiles, howMany, new char[howMany], 0);
        String word = "";
        for(int i = 0; i < extracted.size();i++) {
            word = word + extracted.get(i).getLetter();
        }
        game.getBoard().addWord(this, word);

        game.getBoard().setExtracted(extracted);

        playerScore += game.getBoard().getScore();

    }

    private void submitMyWord(){
        Scanner scanner = new Scanner(System.in);
        String myWord;
        myWord = scanner.next();
        game.getBoard().addWord(this, myWord);
        playerScore += game.getBoard().getScore();
    }

    @Override
    public void run() { // neaparat pt runnable
//        while(running){
//            submitWord();
//        }
        while (!game.isGameFinished()) {

            synchronized (game) {
                if (game.timeUp || game.isGameFinished()) {
                    return;
                }
                while (game.isBoardIsOccupied()) {
                    try {
                        // Make the current thread wait for an opportunity
                        game.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                game.occupyBoard();
//              game.getBag().extractTiles(7);
                game.releaseBoard();
                submitRandomWord();
                // Notify all threads waiting for the gameManager that he is available
                game.notifyAll();
            }

            try {
                // Sleep between 100ms and 300ms
                Thread.sleep((long) (Math.random() * 200 + 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void setGame(Game game) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public double getPlayerScore() {
        return playerScore;
    }
}