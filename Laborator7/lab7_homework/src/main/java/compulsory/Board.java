package compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
   private final List<String> words = new ArrayList<>();
   private static List<Tile> extracted = new ArrayList<>(); // lista de tiles pt a accesa scorul


    private Game game;
    private Timekeeper timekeeper;

    public Board(int maxSecondsToLast){
        timekeeper = new Timekeeper(maxSecondsToLast);
    }

    public void setupRandomGame() {
        Scanner scanner = new Scanner(System.in);

        game = new Game();

        System.out.print("Number of players who play with random words: ");
        int numberOfPlayers = scanner.nextInt();
        String name;
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Player " + i + ": ");
            name = scanner.next();
            game.addPlayer(new Player(name, game));
        }
    }

    public void setupGame() {
        Scanner scanner = new Scanner(System.in);

        game = new Game();

        System.out.print("Number of players who play with given words: ");
        String name;
        int numberOfPlayers = scanner.nextInt();
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Player " + i + ": ");
            name = scanner.next();
            game.addPlayer(new Player(name, game));
        }
        System.out.print("Number of word: ");
//        int numberOfWords =
    }

    public void startGame() {
        Thread[] toDo = new Thread[2];
        toDo[0] = new Thread(game);
        toDo[1] = new Thread(timekeeper);

        toDo[0].start();
        toDo[1].start();

        while (!timekeeper.isOver()) { //&& !game.isGameFinished()
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        game.timeUp = timekeeper.isOver();
    }


//    static ArrayList<String> wordsList = new ArrayList<>();
//
//    public static void iterate(char[] build, int pos) {
//        if (pos == 6) {
//            String word = new String(build);
//            wordsList.add(word);
//            return;
//        }
//        System.out.println(wordsList);
//        for (int i = 0; i < extracted.size(); i++) {
//            build[pos] = extracted.get(i).getLetter();
//            iterate(build, pos + 1);
//        }
//    }


    public void addWord(Player player, String word) {
//        iterate(new char[6], 0);
       // add the word to the collection;
        words.add(word);
        int score = getScore();
        System.out.println(player.getName() + ": " + word + " " + score);
    }

    public int getScore() {
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