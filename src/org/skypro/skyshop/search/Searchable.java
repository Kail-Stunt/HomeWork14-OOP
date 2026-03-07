package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Set;

public interface Searchable {

    String searchTerm();

    String contentType();

    default String getStringRepresentation() {
        return "Имя " + searchTerm() + " тип " + contentType() + " объекта";
    }
}
