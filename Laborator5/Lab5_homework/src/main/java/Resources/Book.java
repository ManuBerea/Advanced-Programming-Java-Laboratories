package Resources;

import Exceptions.ItemException;

public class Book extends Item {

    public Book(String title, String location, String type) throws ItemException {
        super(title, location, type);
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                " \"title\": \"" + title + "\"," +
                " \"location\": \"" + location + "\"," +
                " \"type\": \"" + type + "\"" +
                "}";
    }
}
