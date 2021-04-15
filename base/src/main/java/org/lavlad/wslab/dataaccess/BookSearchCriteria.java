package org.lavlad.wslab.dataaccess;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookSearchCriteria {

    private Long id;

    private String title;

    private String author;

    private Long pages;

    private String synopsis;


    public boolean isEmptyCriteria() {
        return id == null && title == null && author == null && pages == null && synopsis == null;
    }

    public final static BookSearchCriteria EMPTY_CRITERIA = new BookSearchCriteria(null, null, null, null, null) {
        @Override
        public boolean isEmptyCriteria() {
            return true;
        }
    };

}
