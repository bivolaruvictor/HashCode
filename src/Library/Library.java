package Library;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private List<Integer> books;
    private int id;
    private int signDays;
    private int bookPerDay;
    private int maxPoints;
    private int nrBooks;

    public Library () {

    }

    Library(final int signDays, final int bookPerDay, final ArrayList<Integer> books, final int id) {
        this.id = id;
        this.signDays = signDays;
        this.bookPerDay = bookPerDay;
        this.books = books;
        this.maxPoints = 0;
        this.nrBooks = books.size();
    }

    public List<Integer> getBooks() {
        return books;
    }

    public void setBooks(final List<Integer> books) {
        this.books = books;
    }

    public int getSignDays() {
        return signDays;
    }

    public void setSignDays(final int signDays) {
        this.signDays = signDays;
    }

    public int getBookPerDay() {
        return bookPerDay;
    }

    public void setBookPerDay(final int bookPerDay) {
        this.bookPerDay = bookPerDay;
    }

    public void updateBooks(final int point, final int book) {
        this.maxPoints -= point;
        this.books.remove(book);
        this.setNrBooks(nrBooks - 1);
    }

    public int getNrBooks() {
        return nrBooks;
    }

    public void setNrBooks(int nrBooks) {
        this.nrBooks = nrBooks;
    }

    public int calcMaxPoints(final HashMap<Integer, Integer> books) {
        for (int currBook : this.books) {
            for (Integer key : books.keySet()) {
                if (key == currBook) {
                    this.maxPoints += books.get(key);
                }
            }
        }
        this.setMaxPoints(maxPoints);
        return maxPoints;
    }

    public void setMaxPoints(final int max) {
        this.maxPoints = max;
    }

    public int getMaxPoints() {
        return this.maxPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
