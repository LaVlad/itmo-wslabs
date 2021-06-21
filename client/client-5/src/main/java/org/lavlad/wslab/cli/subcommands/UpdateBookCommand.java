package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.BookWebService;
import org.lavlad.wslab.transport.BookTO;
import org.lavlad.wslab.transport.BookUpdateTO;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "update", description = "Update book with specified ID", mixinStandardHelpOptions = true)
public class UpdateBookCommand implements Runnable, BookServiceProvider {

    @Option(names = {"-i", "--id"}, required = true)
    private Long id;

    @Option(names = {"-t", "--title"}, required = true)
    private String title;

    @Option(names = {"-a", "--author"}, required = true)
    private String author;

    @Option(names = {"-p", "--pages"}, required = true)
    private Long pages;

    @Option(names = {"-s", "--synopsis"})
    private String synopsis;

    @Option(names = {"--username"})
    private String username;

    @Option(names = {"--password"})
    private String password;

    @Override
    public void run() {
        BookUpdateTO bookUpdateTO = new BookUpdateTO();
        bookUpdateTO.setTitle(title);
        bookUpdateTO.setAuthor(author);
        bookUpdateTO.setId(id);
        bookUpdateTO.setSynopsis(synopsis);
        bookUpdateTO.setPages(pages);
        BookWebService bookWebService = this.getWithAuth(username, password);
        BookTO updatedBook = bookWebService.updateBook(id, bookUpdateTO);
        System.out.println("Book updated: " + "\nId: " + updatedBook.getId() + "\nTitle: " + updatedBook.getTitle()
                + "\nAuthor: " + updatedBook.getAuthor() + "\nPages: " + updatedBook.getPages()
                + "\nSynopsis: " + updatedBook.getSynopsis() + "\n");
    }
}