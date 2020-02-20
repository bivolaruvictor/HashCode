package main;

import Library.Library;

import java.util.HashMap;
import java.util.List;

public class Input {
    // ce ne trebuie
    private final HashMap<Integer, Integer> sortedMap;
    private final List<Library> libraries;

    public Input(final HashMap<Integer, Integer> sortedMap, final List<Library> libraries) {
        this.sortedMap = sortedMap;
        this.libraries = libraries;
    }
    public Input() {
        this.sortedMap = null;
        this.libraries = null;
    }

    //Getteri

    public HashMap<Integer, Integer> getSortedMap() {
        return sortedMap;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public final boolean isValidInput() {
        return false;
    }
}
