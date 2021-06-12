package org.lavlad.wslab.util;

import org.lavlad.wslab.dataaccess2.BookSearchCriteria;
import org.lavlad.wslab.entity.Book;
import org.lavlad.wslab.transport.BookSearchTO;
import org.lavlad.wslab.transport.BookTO;

public class BookTOUtils {

    public static BookSearchCriteria getSearchCriteriaFromTO(BookSearchTO bookSearchTO) {
        return BookSearchCriteria.of(
                bookSearchTO.getId(),
                bookSearchTO.getTitle(),
                bookSearchTO.getAuthor(),
                bookSearchTO.getPages(),
                bookSearchTO.getSynopsis()
        );
    }

    public static BookTO getBookTOFromEntity(Book book) {
        return BookTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .pages(book.getPages())
                .synopsis(book.getSynopsis())
                .build();
    }

}
