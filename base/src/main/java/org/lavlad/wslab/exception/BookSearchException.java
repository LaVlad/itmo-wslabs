package org.lavlad.wslab.exception;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.ws.WebFault;

@Data
@NoArgsConstructor
@WebFault(faultBean = "org.lavlad.wslab.exception.BookSearchFault")
public class BookSearchException extends Exception{

    private BookSearchFault bookSearchFault;

    public BookSearchException(String message, BookSearchFault bookSearchFault) {
        super(message);
        this.bookSearchFault = bookSearchFault;
    }

    public BookSearchException(String message, BookSearchFault bookSearchFault, Throwable cause) {
        super(message, cause);
        this.bookSearchFault = bookSearchFault;
    }

    public BookSearchFault getFaultInfo() {
        return this.bookSearchFault;
    }
    
}
