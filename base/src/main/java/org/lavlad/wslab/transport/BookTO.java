package org.lavlad.wslab.transport;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookTO {

    private Long id;

    private String title;

    private String author;

    private Long pages;

    private String synopsis;

}
