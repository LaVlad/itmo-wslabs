package org.lavlad.wslab.controllers;

import org.lavlad.wslab.dataaccess2.BookSearchCriteria;
import org.lavlad.wslab.services.BookService;
import org.lavlad.wslab.transport.BookSearchTO;
import org.lavlad.wslab.transport.BookTO;
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

}