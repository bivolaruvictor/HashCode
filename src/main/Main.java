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


        int days, minDays, scanDays;
        List<Integer> answerBooks = new ArrayList<>();
        List<Integer> answerLib = new ArrayList<>();
        List<Integer> bookPerLib = new ArrayList<>();
        while (days <= 0) {
            minDays = days;
            for (Library currLib : allLibraries) {
                if (currLib.getSignDays() < minDays) {
                    minDays = currLib.getSignDays();
                    break;
                }
            }
            scanDays = minDays;
            if (days < scanDays) {
                scanDays = days;
            }
            days -= minDays;
            answerLib.add(currLib.getId());
            allLibraries.remove(currLib);
            while (scanDays != 0) {
                for (int i = 0; i < currLib.getBookPerDay()) {
                    answerBooks = currLib.getBooks().get(i);
                    currLib.updateBooks();
                }
                scanDays--;
            }
        }
    }
}

