package org.lavlad.wslab;

import org.lavlad.wslab.cli.subcommands.CreateBookCommand;
import org.lavlad.wslab.cli.subcommands.DeleteBookCommand;
import org.lavlad.wslab.cli.subcommands.GetBooksCommand;
import org.lavlad.wslab.cli.subcommands.UpdateBookCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

@Command(name = "GetBookClient", subcommands = {
        GetBooksCommand.class,
        CreateBookCommand.class,
        UpdateBookCommand.class,
        DeleteBookCommand.class
}, description = "CLI client to access Book Web Service", mixinStandardHelpOptions = true)
public class App {

    @Spec
    CommandSpec spec;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
