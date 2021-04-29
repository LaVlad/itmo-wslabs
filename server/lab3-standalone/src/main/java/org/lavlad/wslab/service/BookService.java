package org.lavlad.wslab.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.lavlad.wslab.dataaccess2.BookRepository;
import org.lavlad.wslab.dataaccess2.BookSearchCriteria;
import org.lavlad.wslab.entity.Book;
import org.lavlad.wslab.exception.*;
import org.lavlad.wslab.transport.BookCreateTO;
import org.lavlad.wslab.transport.BookSearchTO;
import org.lavlad.wslab.transport.BookUpdateTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@WebService(serviceName = "BookWebService")
@AllArgsConstructor
@NoArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    private Validator validator;

    @WebMethod(operationName = "getBooks")
    public List<Book> getBooks(@WebParam(name = "searchTO") BookSearchTO bookSearchTO) throws BookSearchException {
        Set<ConstraintViolation<BookSearchTO>> constraintViolations = validator.validate(bookSearchTO);
        if (!constraintViolations.isEmpty()) {
            List<String> messages = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new BookSearchException("Exception", new BookSearchFault(messages));
        }
        BookSearchCriteria searchCriteria = BookSearchCriteria.of(
                bookSearchTO.getId(),
                bookSearchTO.getTitle(),
                bookSearchTO.getAuthor(),
                bookSearchTO.getPages(),
                bookSearchTO.getSynopsis()
        );

        return bookRepository.getBooksBy(searchCriteria);
    }

    @WebMethod(operationName = "createBook")
    public Long createBook(@WebParam(name = "createTO") BookCreateTO bookCreateTO) throws BookCreateException {
        Set<ConstraintViolation<BookCreateTO>> constraintViolations = validator.validate(bookCreateTO);
        if (!constraintViolations.isEmpty()) {
            List<String> violations = constraintViolations.stream()
                    .map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new BookCreateException("Exception", new BookCreateFault(violations));
        }
        Book book = Book.builder()
                .title(bookCreateTO.getTitle())
                .author(bookCreateTO.getAuthor())
                .pages(bookCreateTO.getPages())
                .synopsis(bookCreateTO.getSynopsis())
                .build();
        return bookRepository.save(book).getId();
    }

    @WebMethod(operationName = "deleteBookById")
    public void deleteBookById(@WebParam(name = "id") Long id) throws BookNotFoundException {
        validateBookExistOtherwiseThrowException(id);
        
        bookRepository.deleteById(id);
    }

    @WebMethod(operationName = "updateBook")
    public void updateBook(@WebParam(name = "updateTO") BookUpdateTO bookUpdateTO) throws BookNotFoundException, BookUpdateException {
        Set<ConstraintViolation<BookUpdateTO>> constraintViolations = validator.validate(bookUpdateTO);
        if (!constraintViolations.isEmpty()) {
            List<String> violationMessages = constraintViolations.stream()
                    .map(ConstraintViolation::getMessage).collect(Collectors.toList());
            BookUpdateFault updateFault = new BookUpdateFault(violationMessages);
            throw new BookUpdateException("Exception", updateFault);

        }
        
        validateBookExistOtherwiseThrowException(bookUpdateTO.getId());
        
        Book book = bookRepository.findById(bookUpdateTO.getId()).get();
        book.setTitle(bookUpdateTO.getTitle());
        book.setAuthor(bookUpdateTO.getAuthor());
        book.setPages(bookUpdateTO.getPages());
        book.setSynopsis(bookUpdateTO.getSynopsis());

        bookRepository.save(book);
    }

    private void validateBookExistOtherwiseThrowException(Long id) throws BookNotFoundException {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            BookNotFoundFault notFoundFault = BookNotFoundFault.withId(id);
            throw new BookNotFoundException(notFoundFault.getMessage(), notFoundFault);
        }
    }
}
