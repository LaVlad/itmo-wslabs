package org.lavlad.wslab;

import org.apache.commons.cli.*;
import org.lavlad.wslab.service.Book;
import org.lavlad.wslab.service.BookService;
import org.lavlad.wslab.service.BookWebService;

import java.net.MalformedURLException;
import java.net.URL;

public class App {
    public static void main( String[] args ) throws MalformedURLException, ParseException {
        BookService bookService = getBookService();

        final Options options = new Options();

        options.addOption("i", "id", true, "filter by ID");
        options.addOption("t", "title", true, "filter by TITLE");
        options.addOption("a", "author", true, "filter by AUTHOR");
        options.addOption("p", "pages", true, "filter by PAGES");
        options.addOption("s", "synopsis", true, "filter by SYNOPSIS");
        options.addOption("h", "help", false, "show help");

        CommandLineParser parser = new DefaultParser();

        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("wslab-client", options);
            return;
        }

        Long id = null;
        String title = null, author = null, synopsis = null;
        Long pages = null;

        if (cmd.hasOption("i")) {
            id = Long.parseLong(cmd.getOptionValue("i"));
        }

        if (cmd.hasOption("t")) {
            title = cmd.getOptionValue("t");
        }

        if (cmd.hasOption("a")) {
            author = cmd.getOptionValue("a");
        }

        if (cmd.hasOption("s")) {
            synopsis = cmd.getOptionValue("s");
        }

        if (cmd.hasOption("p")) {
            pages = Long.parseLong(cmd.getOptionValue("p"));
        }

        bookService.getBooks(id, title, author, pages, synopsis).stream().map(App::parseBook).forEach(System.out::println);
    }

    private static BookService getBookService() throws MalformedURLException {
        URL serviceUrl = new URL("http://localhost:8080/wslab-server/BookWebService?wsdl");
        return new BookWebService(serviceUrl).getBookServicePort();
    }

    private static String parseBook(Book book) {
        return String.format("Id: %d\nTitle: %s\nAuthor: %s\nPages: %d%s\n",
                book.getId(), book.getTitle(), book.getAuthor(), book.getPages(),
                book.getSynopsis() == null ? "" : String.format("\nSynopsis: \"%s\"", book.getSynopsis()));
    }

}
