package org.lavlad.wslab.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.lavlad.wslab.dataaccess.BookRepository;
import org.lavlad.wslab.dataaccess.BookSearchCriteria;
import org.lavlad.wslab.entity.Book;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "BookWebService")
@AllArgsConstructor
@NoArgsConstructor
public class BookService {

    @Inject
    private BookRepository bookRepository;

    @WebMethod(operationName = "getBooks")
    public List<Book> getBooks(
            @WebParam(name = "id") Long id,
            @WebParam(name = "title") String title,
            @WebParam(name = "author") String author,
            @WebParam(name = "pages") Long pages,
            @WebParam(name = "synopsis") String synopsis) {
        BookSearchCriteria searchCriteria = new BookSearchCriteria(id, title, author, pages, synopsis);
        return bookRepository.searchByCriteria(searchCriteria);
    }

}
