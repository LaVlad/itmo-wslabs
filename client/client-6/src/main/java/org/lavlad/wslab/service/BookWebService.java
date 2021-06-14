package org.lavlad.wslab.service;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.lavlad.wslab.transport.BookCreateTO;
import org.lavlad.wslab.transport.BookSearchTO;
import org.lavlad.wslab.transport.BookTO;
import org.lavlad.wslab.transport.BookUpdateTO;

import java.util.List;

public interface BookWebService {

    @RequestLine("GET /api/book")
    @Headers("Content-type: application/json")
    List<BookTO> searchForBook(@QueryMap BookSearchTO bookSearchTO);

    @RequestLine("POST /api/book")
    @Headers("Content-type: application/json")
    BookTO createBook(@QueryMap BookCreateTO bookCreateTO);

    @RequestLine("PUT /api/book/{id}")
    @Headers("Content-type: application/json")
    BookTO updateBook(@Param("id") Long id, @QueryMap BookUpdateTO bookUpdateTO);

    @RequestLine("DELETE /api/book/{id}")
    void deleteBook(@Param("id") Long id);

}
