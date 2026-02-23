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

    public static void mostSuitable(Searchable searchable, String mostFind) throws BestResultNotFoundException {
        try {
            int index = 0;
            int indexSubString = searchable.searchTerm().indexOf(mostFind, index);
            int stringFound = 0;
            if (searchable.searchTerm() != null && mostFind != null) {
                while (indexSubString != -1) {
                    stringFound++;
                    index = indexSubString + mostFind.length();
                    indexSubString = searchable.searchTerm().indexOf(mostFind, index);
                }
            }
            if (stringFound == 0) {
                throw new BestResultNotFoundException(mostFind);
            } else {
                System.out.println("Количество совпадений для строки \"" + mostFind + "\" в строке \"" + searchable.searchTerm() + "\" составляет " + stringFound + " раз.");
            }
        } catch (BestResultNotFoundException e) {
            System.out.println(e);
        }
    }

}

