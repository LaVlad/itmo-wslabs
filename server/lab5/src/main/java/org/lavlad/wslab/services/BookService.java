package org.lavlad.wslab.services;

import org.lavlad.wslab.dataaccess2.BookRepository;
import org.lavlad.wslab.dataaccess2.BookSearchCriteria;
import org.lavlad.wslab.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(BookSearchCriteria bookSearchCriteria) {
        return bookRepository.getBooksBy(bookSearchCriteria);
    }

    public Book createBook(Book bookToCreate) {
        return bookRepository.save(bookToCreate);
    }

    public Book updateBook(Book bookUpdate) {
        return bookRepository.save(bookUpdate);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
