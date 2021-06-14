package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.exception.BookNotExistsException;
import org.lavlad.wslab.exception.ExceptionHandler;
import org.lavlad.wslab.service.BookWebService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "delete", description = "Delete book by its ID", mixinStandardHelpOptions = true)
public class DeleteBookCommand implements Runnable, BookServiceProvider {

    @Option(names = {"-i", "--id"}, required = true)
    private Long id;

    @Override
    public void run() {
        BookWebService bookWebService = this.get();
        try {
            bookWebService.deleteBook(id);
            System.out.println("Deleted book with id " + id);
        } catch (ExceptionHandler e) {
            System.out.println(e.getMessage());
        }
    }
}
