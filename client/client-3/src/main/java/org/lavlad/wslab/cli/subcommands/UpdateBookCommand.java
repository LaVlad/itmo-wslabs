package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.BookNotFoundException;
import org.lavlad.wslab.service.BookService;
import org.lavlad.wslab.service.BookUpdateException;
import org.lavlad.wslab.service.BookUpdateTO;
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

    @Override
    public void run() {
        BookService bookService = this.get();
        BookUpdateTO bookUpdateTO = new BookUpdateTO();
        bookUpdateTO.setId(id);
        bookUpdateTO.setTitle(title);
        bookUpdateTO.setSynopsis(synopsis);
        bookUpdateTO.setPages(pages);
        bookUpdateTO.setAuthor(author);
        boolean result = false;
        try {
            bookService.updateBook(bookUpdateTO);
            System.out.printf("Book #%d updated:\nTitle: %s\nAuthor: %s\nPages: %d\n%s\n",
                    id,
                    title,
                    author,
                    pages,
                    synopsis == null ? "" : String.format("Synopsis: \"%s\"", synopsis)
            );
        } catch (BookNotFoundException e) {
            System.out.println(e.getFaultInfo().getMessage());
        } catch (BookUpdateException e) {
            e.getFaultInfo().getViolationsMessages().forEach(System.out::println);
        }
    }
}
