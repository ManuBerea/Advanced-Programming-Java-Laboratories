package compulsory;

import java.util.*;

public class Bag {
    private static final List<Tile> tiles = new ArrayList<>();//declare a collection for tiles;
    Random random = new Random(); // creating Random object



    public Bag() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            Tile myTile;
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'l' || letter == 'n' || letter == 's' || letter == 't' || letter == 'r') {
                myTile = new Tile(letter, 1);
            } else if (letter == 'd' || letter == 'g') {
                myTile = new Tile(letter, 2);
            } else if (letter == 'b' || letter == 'c' || letter == 'm' || letter == 'p') {
                myTile = new Tile(letter, 3);
            } else if (letter == 'f' || letter == 'h' || letter == 'v' || letter == 'w' || letter == 'y') {
                myTile = new Tile(letter, 4);
            } else if (letter == 'k') {
                myTile = new Tile(letter, 5);
            } else if (letter == 'j' || letter == 'x') {
                myTile = new Tile(letter, 8);
            } else {
                myTile = new Tile(letter, 10);
            }

            if (letter == 'a' || letter == 'i') {
                for (int i = 1; i <= 9; i++)
                    tiles.add(myTile);
            }
            else if (letter == 'b' || letter == 'c' || letter == 'f' || letter == 'h' || letter == 'm' || letter == 'p' || letter == 'v' || letter == 'w' || letter == 'y') {
                for (int i = 1; i <= 2; i++)
                    tiles.add(myTile);
            }
            else if (letter == 'd' || letter == 'l' || letter == 's' || letter == 'u') {
                for (int i = 1; i <= 4; i++)
                    tiles.add(myTile);
            }
            else if (letter == 'e') {
                for (int i = 1; i <= 12; i++)
                    tiles.add(myTile);
            }
            else if (letter == 'g') {
                for (int i = 1; i <= 3; i++)
                    tiles.add(myTile);
            }
            else if (letter == 'j' || letter == 'k' || letter == 'q' || letter == 'x' || letter == 'z') {
                    tiles.add(myTile);
            }
            else if (letter == 'n' || letter == 'r' || letter == 't' ) {
                for (int i = 1; i <= 6; i++)
                    tiles.add(myTile);
            }
            else {
                for (int i = 1; i <= 8; i++)
                    tiles.add(myTile);
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }

//            System.out.println(wordsList);
//            System.out.println(tiles.size());
            int randomIndex = random.nextInt(1, 1 + tiles.size())-1;

            //extrage o tile cu indexul intre 1 si howMany
            extracted.add(tiles.get(randomIndex));

            //stergem din colectei tile-ul extras
            tiles.remove(randomIndex);
        }
        return extracted;
    }


}
