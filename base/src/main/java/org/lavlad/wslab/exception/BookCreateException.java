package org.lavlad.wslab.exception;

import org.lavlad.wslab.entity.Book;

import javax.xml.ws.WebFault;
import java.sql.SQLException;

@WebFault(faultBean = "org.lavlad.wslab.exception.BookCreateFault")
public class BookCreateException extends Exception {

    private BookCreateFault bookCreateFault;

    public BookCreateException(String message, BookCreateFault fault) {
        super(message);
        this.bookCreateFault = fault;
    }

    public BookCreateException(String message, BookCreateFault fault, Throwable cause) {
        super(message, cause);
        this.bookCreateFault = fault;
    }

    public BookCreateFault getFaultInfo() {
        return bookCreateFault;
    }
}
