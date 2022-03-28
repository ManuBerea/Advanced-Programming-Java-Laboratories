package bibliography;

import Exceptions.ItemException;
import Resources.Article;
import Resources.Book;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Catalog catalog = new Catalog("Catalog1", "C:\\Users\\manub\\IdeaProjects\\Lab5_compulsory\\src\\main\\resources\\items.json");
            catalog.load();

            Book book1 = new Book("Lolo Book", "/lolo/tacp.pdf");
            Article article1 = new Article("Bobo article", "/bobo/art.pdf");

            catalog.addItem(book1);
            catalog.addItem(article1);

            catalog.save();
            System.out.println(catalog);

        } catch (ItemException exp) {
            System.out.println("Main exception : " + exp.getMessage());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
