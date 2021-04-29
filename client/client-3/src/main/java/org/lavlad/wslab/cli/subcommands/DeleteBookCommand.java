package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.BookNotFoundException;
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
        try {
            bookService.deleteBookById(id);
        } catch (BookNotFoundException e) {
            System.out.println(e.getFaultInfo().getMessage());
        }
    }
}
