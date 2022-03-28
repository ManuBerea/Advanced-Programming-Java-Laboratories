package Resources;

import Exceptions.ItemException;

public class Book extends Item {

    public Book(String title, String location) throws ItemException {
        super(title, location);
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                " \"title\": \"" + title + "\"," +
                " \"location\": \"" + location + "\"," +
                " \"type\": \"book\"" +
                "}";
    }
}
