package org.lavlad.wslab.service;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import org.lavlad.wslab.transport.BookSearchTO;
import org.lavlad.wslab.transport.BookTO;

import java.util.List;

public interface BookWebService {

    @RequestLine("GET /api/book")
    @Headers("Content-type: application/json")
    List<BookTO> searchForBook(@QueryMap BookSearchTO bookSearchTO);

}
