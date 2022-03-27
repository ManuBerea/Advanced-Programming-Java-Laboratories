package Lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Street implements Comparable<Street>{
    private final List<Intersection> streetIntersections;
    private final String name;
    private final int length;

    public Street(String name, int length) {
        this.name = name;
        this.length = length;
        this.streetIntersections = new ArrayList<>();
    }

    public int getLength() {
        return length;
    }
    public void setStreetsIntersections(Intersection v) {
        streetIntersections.add(v);
    }

    public List<Intersection> getStreetIntersections() {
        return streetIntersections;
    }

    @Override
    public int compareTo(Street o) {
        if(Objects.equals(this.length, o.getLength())) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Street " +
                name +
                " has " +
                length +
                "km";
    }
}
