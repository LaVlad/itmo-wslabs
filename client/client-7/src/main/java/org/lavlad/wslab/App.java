package org.lavlad.wslab;

import org.lavlad.wslab.cli.subcommands.CreateServiceCommand;
import org.lavlad.wslab.cli.subcommands.GetServiceCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "CRUDProductClient", subcommands = {
        GetServiceCommand.class,
        CreateServiceCommand.class,
}, description = "CLI client to perform UDDI registration and connection", mixinStandardHelpOptions = true)
public class App {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}