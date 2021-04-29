package org.lavlad.wslab.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="library")
@Builder
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    private Long pages;

    private String synopsis;

}
