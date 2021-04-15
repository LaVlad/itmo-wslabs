package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.BookService;
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
        BookService bookService = this.get();
        Long id = bookService.createBook(title, author, pages, synopsis);
        if (id != null) {
            System.out.printf("Created book #%d:\nTitle: %s\nAuthor: %s\nPages: %d%s\n",
                    id,
                    title,
                    author,
                    pages,
                    synopsis == null ? "" : String.format("\nSynopsis: \"%s\"", synopsis)
            );
        } else {
            System.out.println("error creating book");
        }

    }
}
