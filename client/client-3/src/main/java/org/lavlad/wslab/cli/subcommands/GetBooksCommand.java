package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.Book;
import org.lavlad.wslab.service.BookSearchException;
import org.lavlad.wslab.service.BookSearchTO;
import org.lavlad.wslab.service.BookService;
import org.lavlad.wslab.utils.BookUtils;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import sun.security.util.Length;

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
        BookService bookService = this.get();
        BookSearchTO bookSearchTO = new BookSearchTO();
        bookSearchTO.setId(id);
        bookSearchTO.setSynopsis(synopsis);
        bookSearchTO.setTitle(title);
        bookSearchTO.setAuthor(author);
        List<Book> books = null;
        try {
            books = bookService.getBooks(bookSearchTO);
            books.stream().map(BookUtils::bookToString).forEach(System.out::println);
        } catch (BookSearchException e) {
            e.getFaultInfo().getViolationsMessages().forEach(System.out::println);
        }
    }
}
