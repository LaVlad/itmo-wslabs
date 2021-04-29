package org.lavlad.wslab.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BookUpdateFault {

    private String message = "FAILED TO UPDATE BOOK";
    private List<String> violationsMessages = new ArrayList<>();

    public BookUpdateFault(List<String> violationsMessages) {
        this.violationsMessages = violationsMessages;
    }
}
