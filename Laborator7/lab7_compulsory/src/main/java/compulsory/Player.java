package compulsory;

import java.util.*;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running = true;

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    private void submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            running = false;
            return;
        }
        String word = "";
        for(int i = 0; i < extracted.size();i++) {
            word = word + extracted.get(i).getLetter();
        }
        game.getBoard().addWord(this, word);
       /* create a word with all the extracted tiles;
        game.getBoard().addWord(this, word);
        make the player sleep 50ms;*/
        game.getBoard().setExtracted(extracted);

    }

    @Override
    public void run() {
        while(running){
            submitWord();
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
}