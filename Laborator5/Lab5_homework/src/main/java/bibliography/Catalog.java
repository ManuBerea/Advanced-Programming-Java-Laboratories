package bibliography;

import Exceptions.ItemException;
import Resources.Item;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private String name;
    private String jsonPath;
    private final List<Item> items;

    public Catalog(String name, String jsonPath) {
        this.name = name;
        this.jsonPath = jsonPath;
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) throws ItemException {
        if (item == null) {
            throw new ItemException("Add item : Cannot add a null item!");
        }
        item.setId(Integer.toString(this.items.size()));
        this.items.add(item);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getJsonPath() {
        return this.jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\n");
        for (int i = 0; i < this.items.size(); i++) {
            stringBuilder.append(this.items.get(i).toString());
            if (i != this.items.size() - 1) {
                stringBuilder.append(",\n");
            } else {
                stringBuilder.append("\n");
            }
        }
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

}
