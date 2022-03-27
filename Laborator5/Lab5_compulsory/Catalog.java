package bibliography;

import java.util.*;

public class Catalog {
    private String name;
    private int nrItems = 0;
    private final List<Item> items = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        items.add(item);
        nrItems++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void showItems() {
        System.out.println("The Items in the problem are: ");
        for (int i = 0; i < nrItems; i++) {
            System.out.println(items.get(i));
        }
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
