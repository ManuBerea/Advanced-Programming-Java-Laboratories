package Lab4;

public class Intersection {
    private String name;
    private int length;

    public Intersection(String name) {
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}' + "\n";
    }
}
