package Lab4;

import java.util.Objects;

public class Street implements Comparable<Street>{
    private  String name;
    private int length;

    public Street(String name, int length) {
        this.name=name;
        this.length=length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
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
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}' + "\n";
    }
}
