package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.BookService;
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
        boolean result = bookService.updateBook(id, title, author, pages, synopsis);
        if (result) {
            System.out.printf("Update book #%d:\nTitle: %s\nAuthor: %s\nPages: %d%s\n",
                    id,
                    title,
                    author,
                    pages,
                    synopsis == null ? "" : String.format("\nSynopsis: \"%s\"", synopsis)
            );
        } else {
            System.out.println("error updating book");
        }
    }
}
