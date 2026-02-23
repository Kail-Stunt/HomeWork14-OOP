package org.skypro.skyshop.product;

import org.skypro.skyshop.exeptions.BestResultNotFoundException;

import java.util.Arrays;

public class SearchEngine {

    private Searchable[] searchables;
    private int size;
    private int addCount = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
        this.size = size;
    }

    public Searchable[] search(String search) {
        Searchable[] result = new Searchable[5];
        int count = 0;
        for (Searchable s : searchables) {
            if (s.searchTerm().contains(search)) {
                result[count++] = s;
                if (count == 5) break;
            }
        }
        System.out.println("Нашли " + count + " элементов из поиска " + Arrays.toString(result));
        return result;
    }

    public void add(Searchable searchable) {
        if (addCount >= searchables.length) {
            System.out.println("Массив заполнен!");
        } else {
            searchables[addCount] = searchable;
            addCount++;
        }
    }

    public void mostSuitable(String mostFind) throws BestResultNotFoundException {

        try {
            int elementAreFound = 0;
            String element = "";
            for (Searchable s : searchables) {
                int index = 0;
                int stringFound = 0;
                int indexSubString = s.searchTerm().indexOf(mostFind, index);
                if (s.searchTerm() != null && mostFind != null) {
                    while (indexSubString != -1) {
                        stringFound++;
                        index = indexSubString + mostFind.length();
                        indexSubString = s.searchTerm().indexOf(mostFind, index);
                        elementAreFound = 1;
                        element = s.searchTerm();
                    }
                }
            }
            if (elementAreFound == 0) {
                throw new BestResultNotFoundException(mostFind);
            } else {
                System.out.println("По поисковому запросу \"" + mostFind + "\" найден элемент " + element);
            }
        } catch (BestResultNotFoundException e) {
            System.out.println(e);
        }

    }

}


