package org.lavlad.wslab.exception;

public class BookNotExistsException extends RuntimeException {

    private static final String TEMPLATE = "Book with id %s does not exist";

    private final Long id;

    public BookNotExistsException(String id) {
        super(String.format(TEMPLATE, Long.parseLong(id)));
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
