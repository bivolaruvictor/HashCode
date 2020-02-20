package Library;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Integer> books = new ArrayList<>();
    private int signDays;
    private int bookPerDay;
    private int maxPoints;

    Library(final int signDays, final int bookPerDay, final ArrayList<Integer> books) {
        this.signDays = signDays;
        this.bookPerDay = bookPerDay;
        this.books = books;
        this.maxPoints = 0;
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

    public void updatePoints(final int point) {
        this.maxPoints -= point;
    }

    public void calcMaxPoints(final HashMap<Integer, Integer> books) {
         for (Integer value : books.values()) {
             this.maxPoints += value;
         }
    }

    public int getMaxPoints() {
        return this.maxPoints;
    }

}
