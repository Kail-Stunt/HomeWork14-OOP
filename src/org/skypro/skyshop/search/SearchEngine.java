package org.skypro.skyshop.search;

import org.skypro.skyshop.exeptions.BestResultNotFoundException;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.LinkedList;

public class SearchEngine {

    private static final LinkedList<Searchable> searchables = new LinkedList<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public void search(String search) {
        LinkedList<Searchable> result = new LinkedList<>();
        int count = 0;
        for (Searchable s : searchables) {
            if (s.searchTerm().contains(search)) {
                result.add(s);
                ++count;
                if (count == 5) break;
            }
        }
        System.out.println("\nНашли " + count + " элементов из поиска:");
        for (int i = 0; i < count; i++) {
            System.out.println(result.get(i));
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


