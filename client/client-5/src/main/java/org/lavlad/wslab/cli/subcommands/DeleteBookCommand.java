package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.BookWebService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "delete", description = "Delete book by its ID", mixinStandardHelpOptions = true)
public class DeleteBookCommand implements Runnable, BookServiceProvider {

    @Option(names = {"-i", "--id"}, required = true)
    private Long id;

    @Option(names = {"--username"})
    private String username;

    @Option(names = {"--password"})
    private String password;

    @Override
    public void run() {
        BookWebService bookWebService = this.getWithAuth(username, password);
        bookWebService.deleteBook(id);
        System.out.println("Deleted book with id " + id);
    }
}
