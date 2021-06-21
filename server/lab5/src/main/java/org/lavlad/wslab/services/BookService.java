package org.lavlad.wslab.services;

import org.lavlad.wslab.dataaccess2.BookRepository;
import org.lavlad.wslab.dataaccess2.BookSearchCriteria;
import org.lavlad.wslab.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ThrottlingExecutionService throttlingExecutionService;

    public CompletableFuture<List<Book>> searchBooks(BookSearchCriteria bookSearchCriteria) {
        return throttlingExecutionService.submit(() -> bookRepository.getBooksBy(bookSearchCriteria));
    }

    public CompletableFuture<Book> createBook(Book bookToCreate) {
        return throttlingExecutionService.submit(() -> bookRepository.save(bookToCreate));
    }

    public CompletableFuture<Book> updateBook(Book bookUpdate) {
        return throttlingExecutionService.submit(() -> bookRepository.save(bookUpdate));
    }

    public CompletableFuture<?> deleteBook(Long id) {
        return throttlingExecutionService.submit(() -> bookRepository.deleteById(id));
    }

    public CompletableFuture<?> longRunningTask() {
        return throttlingExecutionService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
