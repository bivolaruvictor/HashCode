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



        List<Library> allLibraries = new ArrayList<Library>();
        HashMap<Integer, Integer> sortedMap = new HashMap<>();

        int days, minDays, scanDays, nrBooks;
        List<Integer> answerBooks = new ArrayList<>();
        List<Library> answerLib = new ArrayList<>();
        List<Integer> bookPerLib = new ArrayList<>();
        // get the input
        days = gameInput.getNoDays();
        allLibraries = gameInput.getLibraries();
        sortedMap = gameInput.getSortedMap();

        Library minLib;
        while (days >= 0) {
            minDays = 100000000;
            minLib = null;
            for (Library currLib : allLibraries) {
                if (currLib.getSignDays() <= minDays) {
                    minDays = currLib.getSignDays();
                    minLib = currLib;
                }
            }
            if (minLib == null) {
                break;
            }
            scanDays = minDays;
            if (days < scanDays) {
                scanDays = days;
            }
            days -= minDays;
            answerLib.add(minLib);
            allLibraries.remove(minLib);
            nrBooks = 0;
            while (scanDays != 0) {
                for (int i = 0; i < minLib.getBookPerDay() && minLib.getBooks().size() != 0; ++i) {
                    answerBooks.add(minLib.getBooks().get(i));
                    minLib.updateBooks(sortedMap.get(minLib.getBooks().get(i)), minLib.getBooks().get(i)) ;
                    nrBooks++;
                }
                scanDays--;
            }
            bookPerLib.add(nrBooks);
        }
        try {
            FileSystem fs = new FileSystem(args[0], args[1]);
            fs.writeInt(answerLib.size());
            fs.writeNewLine();
            for (int i = 0; i < answerLib.size(); ++i) {
                fs.writeInt(answerLib.get(i).getId());
                fs.writeWord(" ");
                fs.writeInt(answerLib.get(i).getNrBooks());
                fs.writeNewLine();
                for (int j = 0; j < answerLib.get(i).getNrBooks(); ++j) {
                    fs.writeInt(answerLib.get(i).getBooks().get(j));
                    fs.writeWord(" ");
                }
                fs.writeNewLine();
            }
            fs.writeNewLine();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

