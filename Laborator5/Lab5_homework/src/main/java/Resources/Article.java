package Resources;

import Exceptions.ItemException;

public class Article extends Item {

    public Article(String title, String location, String type) throws ItemException {
        super(title, location, type);
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
