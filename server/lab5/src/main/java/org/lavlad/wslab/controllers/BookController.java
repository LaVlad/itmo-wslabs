package org.lavlad.wslab.controllers;

import org.lavlad.wslab.dataaccess2.BookSearchCriteria;
import org.lavlad.wslab.entity.Book;
import org.lavlad.wslab.services.BookService;
import org.lavlad.wslab.transport.BookCreateTO;
import org.lavlad.wslab.transport.BookSearchTO;
import org.lavlad.wslab.transport.BookTO;
import org.lavlad.wslab.transport.BookUpdateTO;
import org.lavlad.wslab.util.BookTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity<List<BookTO>>> searchBooks(@Valid BookSearchTO bookSearchTO) {
        BookSearchCriteria searchCriteria = BookTOUtils.getSearchCriteriaFromTO(bookSearchTO);
        return bookService.searchBooks(searchCriteria).handle((books, err) -> {
            if (err == null) {
                return ResponseEntity.ok(
                        books.stream().map(BookTOUtils::getBookTOFromEntity).collect(Collectors.toList())
                );
            } else return ResponseEntity.badRequest().build();
        });
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity<BookTO>> createBook(@Valid BookCreateTO bookCreateTO) {
        Book bookToSave = Book.builder()
                .title(bookCreateTO.getTitle())
                .author(bookCreateTO.getAuthor())
                .pages(bookCreateTO.getPages())
                .synopsis(bookCreateTO.getSynopsis())
                .build();
            return bookService.createBook(bookToSave).handle((createdBook, err) -> {
                if (err == null) return ResponseEntity.ok(BookTOUtils.getBookTOFromEntity(createdBook));
                else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            });
    }

    @ResponseBody
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity<BookTO>> updateBook(@PathVariable Long id, @Valid BookUpdateTO bookUpdateTO) {
        Book bookUpdate = Book.builder()
                .id(id)
                .title(bookUpdateTO.getTitle())
                .author(bookUpdateTO.getAuthor())
                .pages(bookUpdateTO.getPages())
                .synopsis(bookUpdateTO.getSynopsis())
                .build();
        return bookService.updateBook(bookUpdate).handle((updatedBook, err) -> {
            if (err == null) {
                ResponseEntity.ok(BookTOUtils.getBookTOFromEntity(updatedBook));
            }
            return ResponseEntity.badRequest().build();
        });
    }

    @GetMapping(path = "/long")
    public CompletableFuture<ResponseEntity> longTask() {
        return bookService.longRunningTask().handle((res, err) -> {
            if (err == null) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        });
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id).handle((res, err) -> {
            if (err == null) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        });
    }

}