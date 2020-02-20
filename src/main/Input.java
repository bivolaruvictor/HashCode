package main;

import Library.Library;

import java.util.HashMap;
import java.util.List;

public class Input {
    // ce ne trebuie
    private final HashMap<Integer, Integer> sortedMap;
    private final List<Library> libraries;
    public final int noDays;

    public Input(final HashMap<Integer, Integer> sortedMap, final List<Library> libraries, int noDays) {
        this.sortedMap = sortedMap;
        this.libraries = libraries;
        this.noDays = noDays;
    }
    public Input() {
        this.noDays = 0;
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

    public int getNoDays() {
        return noDays;
    }

    public final boolean isValidInput() {
        return false;
    }
}
