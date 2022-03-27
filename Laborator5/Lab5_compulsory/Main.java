package bibliography;

public class Main {
    public static void main(String[] args) {
        Item book1 = new Item("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "1967", "Donald E. Knuth", "book");
        Item book2 = new Item("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "2021", "James Gosling & others", "book");

        Catalog catalog = new Catalog("Catalog1");
        catalog.addItem(book1);
        catalog.addItem(book2);

        catalog.showItems();
    }
}

// Not finished