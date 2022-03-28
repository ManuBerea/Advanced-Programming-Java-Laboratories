package bibliography;

import Exceptions.ItemException;
import Resources.Article;
import Resources.Book;
import Resources.Item;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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


    public void load() throws IOException, ParseException, ItemException {
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(this.jsonPath));

        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = (JSONObject) array.get(i);

            String title = (String) obj.get("title");
            String location = (String) obj.get("location");
            String type = (String) obj.get("type");

            if (null != type) {
                if (type.equals("book")) {
                    Item newItem = new Book(title, location);
                    this.addItem(newItem);
                } else if (type.equals("article")) {
                    Item newItem = new Article(title, location);
                    this.addItem(newItem);
                }
            }
        }
    }

    public void save() throws IOException {
        File file = new File(this.jsonPath);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(this.toString());
        fileWriter.flush();
        fileWriter.close();
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
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
