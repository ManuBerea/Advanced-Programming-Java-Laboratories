package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Board {
   private final List<String> words = new ArrayList<>();
   private List<Tile> extracted = new ArrayList<>(); // lista de tiles pt a accesa scorul

    public void addWord(Player player, String word) {
       // add the word to the collection;
        words.add(word);
        int score = getScore(word);
        System.out.println(player.getName() + ": " + word + " " + score);
    }

    public int getScore(String word) {
        int sum = 0;
        for(int i = 0 ; i < extracted.size(); i++) {
            sum = sum + extracted.get(i).getPoints();
        }
        return sum;
    }

    public void setExtracted(List<Tile> extracted) {
        this.extracted = extracted;
    }

    @Override
    public String toString() {
        return words.toString();
    }
}