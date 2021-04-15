package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.BookService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "delete", description = "Delete book by its ID", mixinStandardHelpOptions = true)
public class DeleteBookCommand implements Runnable, BookServiceProvider {

    @Option(names = {"-i", "--id"}, required = true)
    private Long id;

    @Override
    public void run() {
        BookService bookService = this.get();
        boolean result = bookService.deleteBookById(id);
        if (result) {
            System.out.printf("Deleted book #%d\n", id);
        } else {
            System.out.println("error deleting book");
        }
    }
}
