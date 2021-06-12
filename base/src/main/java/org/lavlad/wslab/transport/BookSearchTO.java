package org.lavlad.wslab.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchTO {

    private Long id;
    private String title;
    private String author;
    @Min(value = 0, message = "Pages value must be greater or equal than 0")
    private Long pages;
    private String synopsis;

}

