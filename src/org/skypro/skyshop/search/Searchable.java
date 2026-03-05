package org.skypro.skyshop.search;

public interface Searchable extends Comparable<Searchable> {

    String searchTerm();

    String contentType();

    default String getStringRepresentation() {
        return "Имя " + searchTerm() + " тип " + contentType() + " объекта";
    }
}
