package Lab4;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Intersection[] intersection = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("intersection" + i))
                .toArray(Intersection[]::new);

        int[] lengths = { 2,3,1,1,3,3,2,2,2,1,2,2,1,1,1,2 };

        Street[] streets = IntStream.rangeClosed(0, 15)
                .mapToObj(i -> new Street("street" + i, lengths[i]))
                .toArray(Street[]::new);

        List<Street> streetList = new LinkedList<>(Arrays.asList(streets));

        streetList.sort(Comparator.comparing(Street::getLength));

        Map<Intersection, List<Street>> cityMap = new HashMap<>();
        cityMap.put(intersection[0], Arrays.asList(streets[0], streets[8], streets[6]));
        cityMap.put(intersection[1], Arrays.asList(streets[0], streets[7], streets[1]));
        cityMap.put(intersection[2], Arrays.asList(streets[1], streets[12], streets[15], streets[2]));
        cityMap.put(intersection[3], Arrays.asList(streets[2], streets[14], streets[3]));
        cityMap.put(intersection[4], Arrays.asList(streets[3], streets[15], streets[13], streets[4]));
        cityMap.put(intersection[5], Arrays.asList(streets[4], streets[12], streets[10], streets[5]));
        cityMap.put(intersection[6], Arrays.asList(streets[5], streets[9], streets[6]));
        cityMap.put(intersection[7], Arrays.asList(streets[7], streets[8], streets[9], streets[10], streets[11]));
        cityMap.put(intersection[8], Arrays.asList(streets[11], streets[14], streets[13]));

        System.out.println(cityMap);
    }
}
