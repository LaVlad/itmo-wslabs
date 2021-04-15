package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.Book;
import org.lavlad.wslab.service.BookService;
import org.lavlad.wslab.utils.BookUtils;
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
        BookService bookService = this.get();
        List<Book> books = bookService.getBooks(id, title, author, pages, synopsis);
        books.stream().map(BookUtils::bookToString).forEach(System.out::println);
    }
}
