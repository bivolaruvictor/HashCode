package main;

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


            HashMap sortedMap = sortHash(Books.Books().getBooks());


            System.out.println(sortedMap.toString());
            for (int i = 0; i < noLibraries; ++i) {
                bookValues.add(fs.nextInt());
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new Input(/*rounds, assetsIds, playerOrder*/);
    }

    private HashMap sortHash(HashMap map) {
        HashMap sortedMap = new HashMap<>();
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> aa : list) {
            sortedMap.put(aa.getKey(), aa.getValue());
        }
        return sortedMap;
    }
}
