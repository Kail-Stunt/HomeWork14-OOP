package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;
import java.util.Objects;
import java.util.Set;


import java.util.Objects;

public final class Article implements Searchable {
    private final String articleName;
    private final String articleContent;

    public Article(String articleName, String articleContent) {
        this.articleName = articleName;
        this.articleContent = articleContent;
    }

    @Override
    public String toString() {
        return "Название статьи: " + articleName + "\nСодержание статьи: " + articleContent;
    }

    @Override
    public String searchTerm() {
        return articleName;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleName);
    }

//    @Override
//    public int compareTo(Searchable o) {
//        return 0;
//    }
}
