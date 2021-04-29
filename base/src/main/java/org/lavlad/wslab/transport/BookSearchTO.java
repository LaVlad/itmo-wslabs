package org.lavlad.wslab.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchTO {

    private Long id;
    private String title;
    private String author;
    @Min(value = 0, message = "pages must be greater or equal to 0")
    private Long pages;
    private String synopsis;

}

