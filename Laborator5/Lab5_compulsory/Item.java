package bibliography;

import java.util.*;

public class Item {

    private  String id;
    private  String title;
    private  String location;
    private  String authorName;
    private  String type;
    private  String yearOfPublication;
    private final Map<String, Object> items = new HashMap<>();

    public  Item(String id, String title, String location, String authorName, String yearOfPublication, String type) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.authorName = authorName;
        this.yearOfPublication = yearOfPublication;
        this.type = type;
    }

    public void addItem(String key, Object object) {
        items.put(key, object);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", authorName='" + authorName + '\'' +
                ", type='" + type + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", items=" + items +
                '}';
    }
}
