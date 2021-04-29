package org.lavlad.wslab.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.ws.WebFault;

@Data
@NoArgsConstructor
@WebFault(faultBean = "org.lavlad.wslab.exception.BookNotFoundFault")
public class BookNotFoundException extends Exception {

    private BookNotFoundFault bookNotFoundFault;

    public BookNotFoundException(String message, BookNotFoundFault bookNotFoundFault) {
        super(message);
        this.bookNotFoundFault = bookNotFoundFault;
    }

    public BookNotFoundException(String message, BookNotFoundFault bookNotFoundFault, Throwable cause) {
        super(message, cause);
        this.bookNotFoundFault = bookNotFoundFault;
    }

    public BookNotFoundFault getFaultInfo() {
        return this.bookNotFoundFault;
    }

}
