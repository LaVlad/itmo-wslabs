package org.lavlad.wslab.cli.subcommands;

import org.lavlad.wslab.service.*;
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
        BookCreateTO createTO = new BookCreateTO();
        createTO.setTitle(title);
        createTO.setSynopsis(synopsis);
        createTO.setAuthor(author);
        createTO.setPages(pages);
        Long id = null;
        try {
            id = bookService.createBook(createTO);
            System.out.println("book created with id: "+id);
        } catch (BookCreateException e) {
            BookCreateFault fault = e.getFaultInfo();
            fault.getViolationMessages().forEach(System.out::println);
        }

    }
}
