package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.BookWebService;
import org.lavlad.wslab.transport.BookCreateTO;
import org.lavlad.wslab.transport.BookTO;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "create", description = "Create book with specified properties", mixinStandardHelpOptions = true)
public class CreateBookCommand implements Runnable, BookServiceProvider {

    @Option(names = {"-t", "--title"}, required = true)
    private String title;

    @Option(names = {"-a", "--author"}, required = true)
    private String author;

    @Option(names = {"-p", "--pages"}, required = true)
    private Long pages;

    @Option(names = {"-s", "--synopsis"})
    private String synopsis;

    @Override
    public void run() {
        BookCreateTO bookCreateTO = new BookCreateTO();
        bookCreateTO.setTitle(title);
        bookCreateTO.setAuthor(author);
        bookCreateTO.setPages(pages);
        bookCreateTO.setSynopsis(synopsis);
        BookWebService bookWebService = this.get();
        BookTO createdBook = bookWebService.createBook(bookCreateTO);
        System.out.println("Book created: " + "\nId: " + createdBook.getId() + "\nTitle: " + createdBook.getTitle()
                + "\nAuthor: " + createdBook.getAuthor() + "\nPages: " + createdBook.getPages()
                + "\nSynopsis: " + createdBook.getSynopsis() + "\n");
    }
}