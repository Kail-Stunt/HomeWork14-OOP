package org.skypro.skyshop.product;

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

}
