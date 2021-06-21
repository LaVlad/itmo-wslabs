package org.lavlad.wslab.cli.subcommands;

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

    @Option(names = {"--username"})
    private String username;

    @Option(names = {"--password"})
    private String password;

    @Override
    public void run() {
        BookWebService bookService = this.getWithAuth(username, password);
        BookSearchTO bookSearchTO = new BookSearchTO();
        bookSearchTO.setId(id);
        bookSearchTO.setSynopsis(synopsis);
        bookSearchTO.setTitle(title);
        bookSearchTO.setAuthor(author);
        bookSearchTO.setPages(pages);
        List<BookTO> books = bookService.searchForBook(bookSearchTO);
        books.forEach(book -> {
            System.out.println("Id: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Pages: " + book.getPages());
            System.out.println("Synopsis: " + book.getSynopsis() + "\n");
        });
    }
}
