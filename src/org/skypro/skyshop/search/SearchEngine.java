package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public void search(ArrayList<String> search) {
        Set<Searchable> result = searchables.stream()
                .filter(s -> search.stream().anyMatch(articleName -> s.searchTerm().contains(articleName)))
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(
                                Comparator.comparingInt((Searchable s) -> s.searchTerm().length())
                                        .thenComparing(Searchable::searchTerm)
                                        .reversed()
                        )
                ));
        System.out.println("\nНашли " + result.size() + " элементов из поиска: \nвыведем отсортированный по длине названия статьи список:");
        result.forEach(System.out::println);

//    public void mostSuitable(String mostFind) throws BestResultNotFoundException {
//
//        try {
//            int elementAreFound = 0;
//            String element = "";
//            for (Searchable s : searchables) {
//                int index = 0;
//                int stringFound = 0;
//                int indexSubString = s.searchTerm().indexOf(mostFind, index);
//                if (s.searchTerm() != null && mostFind != null) {
//                    while (indexSubString != -1) {
//                        stringFound++;
//                        index = indexSubString + mostFind.length();
//                        indexSubString = s.searchTerm().indexOf(mostFind, index);
//                        elementAreFound = 1;
//                        element = s.searchTerm();
//                    }
//                }
//            }
//            if (elementAreFound == 0) {
//                throw new BestResultNotFoundException(mostFind);
//            } else {
//                System.out.println("По поисковому запросу \"" + mostFind + "\" найден элемент " + element);
//            }
//        } catch (BestResultNotFoundException e) {
//            System.out.println(e);
//        }
//
//    }
    }
}
