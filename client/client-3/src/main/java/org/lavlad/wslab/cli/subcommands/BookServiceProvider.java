package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.BookService;
import org.lavlad.wslab.service.BookWebService;

import java.net.MalformedURLException;
import java.net.URL;

public interface BookServiceProvider {

    default BookService get() {
        URL serviceUrl = null;
        try {
            serviceUrl = new URL("http://localhost:8080/wslab-server/BookWebService?wsdl");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Can't access web service");
        }
        return new BookWebService(serviceUrl).getBookServicePort();
    }

}
