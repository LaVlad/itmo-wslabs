package org.lavlad.wslab.exception;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "org.lavlad.wslab.exception.BookUpdateFaule")
public class BookUpdateException extends Exception {

    private BookUpdateFault bookUpdateFault;

    public BookUpdateException(String message, BookUpdateFault bookUpdateFault) {
        super(message);
        this.bookUpdateFault = bookUpdateFault;
    }

    public BookUpdateException(String message, BookUpdateFault bookUpdateFault, Throwable cause) {
        super(message, cause);
        this.bookUpdateFault = bookUpdateFault;
    }

    public BookUpdateFault getFaultInfo() {
        return this.bookUpdateFault;
    }

}
