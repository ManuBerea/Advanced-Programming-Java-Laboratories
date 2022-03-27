package Lab4;

import java.util.*;
import java.util.stream.IntStream;
import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Intersection[] intersection = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection(faker.name().name()))
                .toArray(Intersection[]::new);

        int[] lengths = { 2,3,1,1,3,3,2,2,2,1,2,2,1,1,1,2 };

        Street[] street = IntStream.rangeClosed(0, 15)
                .mapToObj(i -> new Street(faker.address().streetName(), lengths[i]))
                .toArray(Street[]::new);

        List<Street> streetsList = new LinkedList<>(Arrays.asList(street));
        streetsList.sort(Comparator.comparing(Street::getLength));

        Map<Intersection, List<Street>> cityMap = new HashMap<>();
        cityMap.put(intersection[0], Arrays.asList(street[0], street[8], street[6]));
        cityMap.put(intersection[1], Arrays.asList(street[0], street[7], street[1]));
        cityMap.put(intersection[2], Arrays.asList(street[1], street[12], street[15], street[2]));
        cityMap.put(intersection[3], Arrays.asList(street[2], street[14], street[3]));
        cityMap.put(intersection[4], Arrays.asList(street[3], street[15], street[13], street[4]));
        cityMap.put(intersection[5], Arrays.asList(street[4], street[12], street[10], street[5]));
        cityMap.put(intersection[6], Arrays.asList(street[5], street[9], street[6]));
        cityMap.put(intersection[7], Arrays.asList(street[7], street[8], street[9], street[10], street[11]));
        cityMap.put(intersection[8], Arrays.asList(street[11], street[14], street[13]));

        out.println("\nThe map of the city:");
        out.println(cityMap);

        City city = new City(faker.name().name());
        out.println("\nCity Name: ");
        out.println(city.getCityName());

        city.setCityMap(cityMap);
        city.setStreetsList(streetsList);

        out.println("\nStreets longer than a specified value which join at least other 3 streets:");
        out.println(city.getStreets(1));

        Graph<Intersection,Street> graph = new DefaultDirectedWeightedGraph<>(null,null);
        for (Intersection i:intersection) {
            graph.addVertex(i);
        }
        city.setStreetsIntersections();
        city.getStreetsList().forEach(streets->graph.addEdge(streets.getStreetIntersections().get(0),streets.getStreetIntersections().get(1), streets));
        city.getStreetsList().forEach(streets->graph.setEdgeWeight(streets, streets.getLength()));

        PrimMinimumSpanningTree MST = new PrimMinimumSpanningTree(graph);

        out.println("\nSolution:");
        out.println(MST.getSpanningTree());
    }
}
