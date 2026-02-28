package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String articleName;
    private final String articleContent;

    public Article(String articleName, String articleContent) {
        this.articleName = articleName;
        this.articleContent = articleContent;
    }

    @Override
    public String toString() {
        return " Название статьи: " + articleName + "\nСодержание статьи: " + articleContent;
    }

    @Override
    public String searchTerm() {
        return " Название статьи: " + articleName + "\nСодержание статьи: " + articleContent;
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        Searchable.super.getStringRepresentation();
        return null;
    }
}
