package org.lavlad.wslab.cli.subcommands;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.lavlad.wslab.service.BookWebService;
import org.lavlad.wslab.service.WslabErrorDecoder;

public interface BookServiceProvider {

    default BookWebService get() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .errorDecoder(new WslabErrorDecoder())
                .target(BookWebService.class, "http://localhost:8080");
    }

}
