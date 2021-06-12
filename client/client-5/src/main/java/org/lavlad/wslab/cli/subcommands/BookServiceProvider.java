package org.lavlad.wslab.cli.subcommands;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.lavlad.wslab.service.BookWebService;

public interface BookServiceProvider {

    default BookWebService get() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(BookWebService.class, "http://localhost:8080");
    }

}
