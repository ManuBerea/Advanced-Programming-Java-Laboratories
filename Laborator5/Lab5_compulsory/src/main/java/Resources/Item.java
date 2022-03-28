package Resources;

import Exceptions.ItemException;

public abstract class Item {

    protected String id;
    protected String title;
    protected String location;

    public Item(String title, String location) throws ItemException {
        if (title == null) {
            throw new ItemException("Please provide the title of the item!");
        }

        this.title = title;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
