package Resources;

import Exceptions.ItemException;

public class Article extends Item {

    public Article(String title, String location) throws ItemException {
        super(title, location);
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                " \"title\": \"" + title + "\"," +
                " \"location\": \"" + location + "\"," +
                " \"type\": \"article\"" +
                "}";
    }
}
