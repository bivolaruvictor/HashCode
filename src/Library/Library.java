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

    public void updatePoints(final int point) {
        this.maxPoints -= point;
    }

    public int getNrBooks() {
        return nrBooks;
    }

    public void setNrBooks(int nrBooks) {
        this.nrBooks = nrBooks;
    }

    public void calcMaxPoints(final HashMap<Integer, Integer> books) {
         for (Integer value : books.values()) {
             this.maxPoints += value;
         }
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

    List<Integer> answerBooks = new ArrayList<>();
    List<Integer> answerLib = new ArrayList<>();
    List<Integer> bookPerLib = new ArrayList<>();
    while (days <= 0) {
        minDays = days;
        for (Library currLib : allLibraries) {
            if (currLib.getSignDays() < minDays) {
                minDays = currLib.getSignDays();
            }
        }
        scanDays = minDays;
        days -= minDays;
        answerLib.add(currLib.getId());
        while (scanDays != 0) {
            for (int i = 0; i < )
        }
    }
}
