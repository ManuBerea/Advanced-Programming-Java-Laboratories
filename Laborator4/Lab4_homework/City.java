package Lab4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class City {
    private final String name;
    private Map<Intersection, List<Street>> cityMap = new HashMap<>();
    private List<Street> streetsList;

    public City(String name) {
        this.name = name;
    }
    public String getCityName() {
        return name;
    }

    public List<Street> getStreetsList() {
        return streetsList;
    }

    public void setStreetsList(List<Street> streetList) {
        this.streetsList = streetList;
    }

    public void setCityMap(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public void setStreetsIntersections() {
        for(var i : cityMap.keySet()){
            for(var j : cityMap.get(i)){
                j.setStreetsIntersections(i);
            }
        }
    }
    private int numberOfStreets(Street street) {
        int sum = 0;
        for(var i : cityMap.keySet()){
            for(var j : cityMap.get(i)) {
                if(j.equals(street)){
                    for(var k : cityMap.get(i)) {
                        if(!(k.equals(street))) {
                            sum++;
                        }
                    }
                    break;
                }
            }
        }
        return sum;
    }

    public String getStreets (int length) {
        Stream<Street> stream = streetsList.stream();
        return  stream.filter(street -> street.getLength() >= length).filter(street -> numberOfStreets(street)>=3)
                .map(Street::toString).collect(Collectors.joining("\n"));
    }

}
