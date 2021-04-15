package org.lavlad.wslab.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.lavlad.wslab.dataaccess.BookRepository;
import org.lavlad.wslab.dataaccess.BookSearchCriteria;
import org.lavlad.wslab.entity.Book;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "BookWebService")
@AllArgsConstructor
@NoArgsConstructor
public class BookService {

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

    @WebMethod(operationName = "createBook")
    public Long createBook(
            @WebParam(name = "title") String title,
            @WebParam(name = "author") String author,
            @WebParam(name = "pages") Long pages,
            @WebParam(name = "synopsis") String synopsis) {
        return bookRepository.createBook(title, author, pages, synopsis);
    }

    @WebMethod(operationName = "deleteBookById")
    public boolean deleteBookById(
            @WebParam(name = "id") Long id) {
        return bookRepository.deleteBookById(id);
    }

    @WebMethod(operationName = "updateBook")
    public boolean updateBook(
            @WebParam(name = "id") Long id,
            @WebParam(name = "title") String title,
            @WebParam(name = "author") String author,
            @WebParam(name = "pages") Long pages,
            @WebParam(name = "synopsis") String synopsis) {
        Book bookUpdate = new Book(id, title, author, pages, synopsis);
        return bookRepository.updateBook(bookUpdate);
    }
}
