package org.lavlad.wslab.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookNotFoundFault {

    private static final String DEFAULT_MESSAGE = "book id cannot be null";
    private static final String MESSAGE_FORMAT = "no book with id: %d";

    private String message;

    public static BookNotFoundFault nullValue() {
        BookNotFoundFault bookNotFoundFault = new BookNotFoundFault();
        bookNotFoundFault.setMessage(DEFAULT_MESSAGE);
        return bookNotFoundFault;
    }

    public static BookNotFoundFault withId(long id) {
        BookNotFoundFault bookNotFoundFault = new BookNotFoundFault();
        bookNotFoundFault.setMessage(String.format(MESSAGE_FORMAT, id));
        return bookNotFoundFault;
    }

}
