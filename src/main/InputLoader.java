package main;

import Library.Library;
import main.Books;

import java.util.*;

import fileio.FileSystem;

public final class InputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    InputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public Input load() {
        List<Integer> bookIds = new ArrayList<>();
        List<Integer> bookValues = new ArrayList<>();
        HashMap books = Books.Books().getBooks();
        List<Library> libraries = new ArrayList<Library>();
        int noBooks = 0;
        int noLibraries = 0;
        int noDays = 0;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            noBooks = fs.nextInt();
            noLibraries = fs.nextInt();
            noDays = fs.nextInt();

            for (int i = 0; i < noBooks; ++i) {
                bookValues.add(fs.nextInt());
            }

            for (int i = 0; i < noBooks; ++i) {
                Books.Books().getBooks().put(i, bookValues.get(i));
            }


            HashMap sortedMap = sortHashMapByValues(Books.Books().getBooks());



            for (int i = 0; i < noLibraries; ++i) {
                libraries.get(i).setNrBooks(fs.nextInt());
                libraries.get(i).setSignDays(fs.nextInt());
                libraries.get(i).setBookPerDay(fs.nextInt());
                for (int j = 0; j < libraries.get(i).getNrBooks(); ++j) {
                    libraries.get(i).getBooks().add(fs.nextInt());
                }
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new Input(/*rounds, assetsIds, playerOrder*/);
    }

    public LinkedHashMap<Integer, Integer> sortHashMapByValues(
            HashMap<Integer, Integer> passedMap) {
        List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues, Collections.reverseOrder());
        Collections.sort(mapKeys);

        LinkedHashMap<Integer, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<Integer> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Integer key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}
