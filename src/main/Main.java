package main;

import fileio.FileSystem;
import main.InputLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Main {
    private Main() {
        // just to trick checkstyle
    }

    public static void main(final String[] args) {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input gameInput = inputLoader.load();
        try {

            //fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

