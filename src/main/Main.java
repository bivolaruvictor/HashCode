package main;

import Library.Library;
import fileio.FileSystem;
import main.InputLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public final class Main {
    private Main() {
        // just to trick checkstyle
    }

    public static void main(final String[] args) {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input gameInput = inputLoader.load();
        try {
            FileSystem fs = new FileSystem(args[0], args[1]);
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Library> allLibraries = new ArrayList<Library>();
        HashMap<Integer, Integer> sortedMap = new HashMap<>();

        int days, minDays, scanDays, nrBooks;
        List<Integer> answerBooks = new ArrayList<>();
        List<Integer> answerLib = new ArrayList<>();
        List<Integer> bookPerLib = new ArrayList<>();
        // get the input
        days = gameInput.getNoDays();
        allLibraries = gameInput.getLibraries();
        sortedMap = gameInput.getSortedMap();

        Library minLib;
        while (days <= 0) {
            minDays = days;
            minLib = null;
            for (Library currLib : allLibraries) {
                if (currLib.getSignDays() < minDays) {
                    minDays = currLib.getSignDays();
                    minLib = currLib;
                }
            }
            scanDays = minDays;
            if (days < scanDays) {
                scanDays = days;
            }
            days -= minDays;
            answerLib.add(minLib.getId());
            allLibraries.remove(minLib);
            nrBooks = 0;
            while (scanDays != 0) {
                for (int i = 0; i < minLib.getBookPerDay(); ++i) {
                    answerBooks.add(minLib.getBooks().get(i));
                    minLib.updateBooks(sortedMap.get(minLib.getBooks().get(i)), minLib.getBooks().get(i));
                    for (Library restLib : allLibraries) {
                        if (restLib.getId() != minLib.getId()) {
                            for (Integer sameBook : restLib.getBooks()) {
                                if (sameBook == minLib.getBooks().get(i)) {
                                    restLib.updateBooks(sortedMap.get(minLib.getBooks().get(i)), minLib.getBooks().get(i));
                                }
                            }
                        }
                    }
                }
                scanDays--;
                nrBooks++;
            }
            bookPerLib.add(nrBooks);
        }
    }
}

