package org.skypro.skyshop.product;

public interface Searchable {

    String searchTerm();

    String contentType();

    default String getStringRepresentation() {
        return "Имя " + searchTerm() + " тип " + contentType() + " объекта";
    }
}
