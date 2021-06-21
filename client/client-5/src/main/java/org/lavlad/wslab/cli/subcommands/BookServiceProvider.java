package org.lavlad.wslab.cli.subcommands;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
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

    default BookWebService getWithAuth(String username, String password) {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .requestInterceptor(new BasicAuthRequestInterceptor(username, password))
                .target(BookWebService.class, "http://localhost:8080");
    }

}
