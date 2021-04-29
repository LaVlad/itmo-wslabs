package org.lavlad.wslab.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BookSearchFault {

    private List<String> violationsMessages = new ArrayList<>();
    private String message;

    public BookSearchFault(List<String> violationsMessages) {
        this.violationsMessages = violationsMessages;
    }

}
