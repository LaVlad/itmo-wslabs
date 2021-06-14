package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.exception.BookNotFoundException;
import org.lavlad.wslab.exception.ExceptionHandler;
import org.lavlad.wslab.exception.InvalidBookException;
import org.lavlad.wslab.service.BookWebService;
import org.lavlad.wslab.transport.BookSearchTO;
import org.lavlad.wslab.transport.BookTO;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.List;

@Command(name = "get", description = "Get list of books satisfying specified criteria", mixinStandardHelpOptions = true)
public class GetBooksCommand implements Runnable, BookServiceProvider {

    @Option(names = {"-i", "--id"})
    private Long id;

    @Option(names = {"-t", "--title"})
    private String title;

    @Option(names = {"-a", "--author"})
    private String author;

    @Option(names = {"-p", "--pages"})
    private Long pages;

    @Option(names = {"-s", "--synopsis"})
    private String synopsis;

    @Override
    public void run() {
        BookWebService bookService = this.get();
        BookSearchTO bookSearchTO = new BookSearchTO();
        bookSearchTO.setId(id);
        bookSearchTO.setSynopsis(synopsis);
        bookSearchTO.setTitle(title);
        bookSearchTO.setAuthor(author);
        bookSearchTO.setPages(pages);
        try {
            List<BookTO> books = bookService.searchForBook(bookSearchTO);
            if (books.isEmpty()) throw new ExceptionHandler("Book with specified parameters does not exist.");
            books.forEach(book -> {
                System.out.println("Id: " + book.getId() + "\nTitle: " + book.getTitle()
                        + "\nAuthor: " + book.getAuthor() + "\nPages: " + book.getPages()
                        + "\nSynopsis: " + book.getSynopsis() + "\n");
            });
        } catch (ExceptionHandler e) {
            System.out.println(e.getMessage());
        }
    }
}
