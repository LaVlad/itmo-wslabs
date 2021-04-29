package org.lavlad.wslab.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BookCreateFault {

    private String message = "FAILED TO CREATE BOOK";
    private List<String> violationMessages = new ArrayList<>();

    public BookCreateFault(List<String> violationMessages) {
        this.violationMessages = violationMessages;
    }


}
