package compulsory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game implements Runnable{
    private final Bag bag = new Bag();
    private final Board board = new Board(1);
//    ArrayList<String> wordsFromDictionary = new ArrayList<>();
//    private final Dictionary dictionary = new Dictionary(wordsFromDictionary);
    private final List<Player> players = new ArrayList<>();

    boolean timeUp = false;
    boolean isGameFinished = false;
    private boolean boardIsOccupied = false;

    public void addPlayer(Player p) {
        if (!players.contains(p)) {
            players.add(p);
        }
        else {
            System.out.println("Cannot insert the same player twice.");
        }
    }

    public Bag getBag() {
        return bag;
    }

//    public Board getBoard() {
//        return board;
//    }

//    public Dictionary getDictionary() {
//        return dictionary;
//    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void run() {
        startGame();
    }

    public void startGame() {
        // Create threads
        Thread[] threadList = new Thread[players.size()];
        for (int i = 0; i < threadList.length; i++) {
            threadList[i] = new Thread(players.get(i));
        }

        // Run each player
        for (Thread thread : threadList) {
            thread.start();
        }

        while (!isGameFinished && !timeUp) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!timeUp) {
            while (boardIsOccupied) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Time's up!\n");
        }

        int maxim = 0, winnerIndex = 0;
        for (int i = 0; i < players.size(); i++){
            if(players.get(i).getPlayerScore() > maxim){
                maxim = (int) players.get(i).getPlayerScore();
                winnerIndex = i;
            }
            System.out.print("The score of ");
            System.out.print(players.get(i).getName());
            System.out.print(" is: ");
            System.out.println(players.get(i).getPlayerScore());
        }

        System.out.print("\nThe winner is:");
        System.out.println(players.get(winnerIndex).getName());

//        System.out.println("\n________________________________\n");
//        System.out.println("Verify if your words are found in the dictionary");
    }

    public static void main(String[] args) {
//        Game game = new Game();
//        game.addPlayer(new Player("Player 1", game));
//        game.addPlayer(new Player("Player 2", game));
//        game.addPlayer(new Player("Player 3", game));
        // game.getDictionary();
//        game.play();

        Board board = new Board(1);
        board.setupRandomGame();
        board.startGame();
      //  board.setupGame();

    }

    public boolean isGameFinished() {
        return isGameFinished;
    }

    public boolean isBoardIsOccupied() {
        return boardIsOccupied;
    }
    public Board getBoard() {
        return board;
    }

    public void occupyBoard() {
        this.boardIsOccupied = true;
    }

    public void releaseBoard() {
        this.boardIsOccupied = false;
    }
}
