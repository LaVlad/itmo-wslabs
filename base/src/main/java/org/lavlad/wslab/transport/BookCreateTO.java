package org.lavlad.wslab.transport;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
public class BookCreateTO {

    @Size(min = 1, max=255)
    @NotNull(message = "title must be specified")
    private String title;

    @Size(min = 1, max=255)
    @NotNull(message = "author must be specified")
    private String author;

    @Min(value = 0, message = "pages must be greater or equal to 0")
    private Long pages;

    @Size(min = 1, max = 255)
    private String synopsis;
}
