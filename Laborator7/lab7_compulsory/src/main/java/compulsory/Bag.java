package compulsory;

import java.util.*;

public class Bag {
    private final List<Tile> tiles = new ArrayList<>();//declare a collection for tiles;
    Random random = new Random(); // creating Random object

    public Bag() {
        for (char letter = 'a'; letter < 'z'; letter++) {
            Tile myTile = new Tile(letter, random.nextInt(1, 11));
            for (int i = 0; i < 10; i++) {
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
            int randomIndex = random.nextInt(1, 1 + tiles.size())-1;

            //extrage o tile cu indexul intre 1 si howMany
            extracted.add(tiles.get(randomIndex));

            //stergem din colectei tile-ul extras
            tiles.remove(randomIndex);
        }
        return extracted;
    }

}
