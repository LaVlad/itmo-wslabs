package org.lavlad.wslab.dataaccess2;

import java.util.Optional;

public class BookSearchCriteria {

    private final Long id;
    private final String title;
    private final String author;
    private final Long pages;
    private final String synopsis;

    private BookSearchCriteria(
            Long id,
            String title,
            String author,
            Long pages,
            String synopsis
    ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.synopsis = synopsis;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(this.id);
    }

    public Optional<String> getTitle() {
        return Optional.ofNullable(this.title);
    }

    public Optional<String> getAuthor() {
        return Optional.ofNullable(this.author);
    }

    public Optional<Long> getPages() {
        return Optional.ofNullable(this.pages);
    }

    public Optional<String> getSynopsis() {
        return Optional.ofNullable(this.synopsis);
    }

    public static BookSearchCriteria of(Long id, String title, String author, Long pages, String synopsis) {
        return new BookSearchCriteria(id, title, author, pages, synopsis);
    }
}
