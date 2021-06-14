package org.lavlad.wslab.service;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.lavlad.wslab.exception.ExceptionHandler;
import org.lavlad.wslab.exception.InvalidBookException;
import org.lavlad.wslab.exception.BookNotExistsException;

import java.io.IOException;

public class WslabErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 400) {
            try {
                throw new ExceptionHandler(Util.toString(response.body().asReader(Util.UTF_8)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (response.status() == 409) {
            try {
                throw new ExceptionHandler(Util.toString(response.body().asReader(Util.UTF_8)));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return new ErrorDecoder.Default().decode(s, response);
    }
}
