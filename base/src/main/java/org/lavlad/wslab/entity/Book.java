package org.lavlad.wslab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    private Long id;

    private String title;

    private String author;

    private Long pages;

    private String synopsis;

}
