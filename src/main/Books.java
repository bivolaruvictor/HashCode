package main;

import java.util.HashMap;

public class Books {
    private static Books library = null;
    private HashMap books = new HashMap();

    public HashMap getBooks() {
        return books;
    }

    public void setBooks(HashMap books) {
        this.books = books;
    }

    public static Books Books() {
        if (library == null) {
            library = new Books();
        }
        return library;
    }
}
