package org.lavlad.wslab.utils;

import org.lavlad.wslab.service.Book;

public class BookUtils {

    public static String bookToString(Book book) {
        return String.format("Id: %d\nTitle: %s\nAuthor: %s\nPages: %d%s\n",
                book.getId(), book.getTitle(), book.getAuthor(), book.getPages(),
                book.getSynopsis() == null ? "" : String.format("\nSynopsis: \"%s\"", book.getSynopsis()));
    }

}
