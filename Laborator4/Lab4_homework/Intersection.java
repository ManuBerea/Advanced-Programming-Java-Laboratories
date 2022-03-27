package Lab4;

public class Intersection {
    private final String name;

    public Intersection(String intersectionName) {
        this.name = intersectionName;
    }

    @Override
    public String toString() {
        return "\nIntersection " +
                name + ":\n";
    }
}
