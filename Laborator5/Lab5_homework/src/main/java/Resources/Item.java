package Resources;

import Exceptions.ItemException;

public abstract class Item {

    protected String id;
    protected String title;
    protected String location;
    protected String type;

    public Item(String title, String location, String type) throws ItemException {
        if (title == null) {
            throw new ItemException("Please provide the title of the item!");
        }
        this.title = title;
        this.location = location;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                " \"title\": \"" + title + "\"," +
                " \"location\": \"" + location + "\"" +
                "}";
    }
}
