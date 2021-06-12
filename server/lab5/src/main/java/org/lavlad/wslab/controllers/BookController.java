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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    public ResponseEntity<List<BookTO>> searchBooks(@Valid BookSearchTO bookSearchTO) {
        BookSearchCriteria searchCriteria = BookTOUtils.getSearchCriteriaFromTO(bookSearchTO);
        List<BookTO> searchResult = bookService.searchBooks(searchCriteria)
                .stream().map(BookTOUtils::getBookTOFromEntity).collect(Collectors.toList());

        return ResponseEntity.ok(searchResult);
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookTO> createBook(@Valid BookCreateTO bookCreateTO) {
        Book bookToSave = Book.builder()
                .title(bookCreateTO.getTitle())
                .author(bookCreateTO.getAuthor())
                .pages(bookCreateTO.getPages())
                .synopsis(bookCreateTO.getSynopsis())
                .build();
        Book createdBook = bookService.createBook(bookToSave);
        return ResponseEntity.ok(BookTOUtils.getBookTOFromEntity(createdBook));
    }

    @ResponseBody
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookTO> updateBook(@PathVariable Long id, @Valid BookUpdateTO bookUpdateTO) {
        Book bookUpdate = Book.builder()
                .id(id)
                .title(bookUpdateTO.getTitle())
                .author(bookUpdateTO.getAuthor())
                .pages(bookUpdateTO.getPages())
                .synopsis(bookUpdateTO.getSynopsis())
                .build();
        Book updatedBook = bookService.updateBook(bookUpdate);
        return ResponseEntity.ok(BookTOUtils.getBookTOFromEntity(updatedBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}