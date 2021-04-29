package org.lavlad.wslab.dataaccess2;

import org.lavlad.wslab.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookGETRepository {

    List<Book> getBooksBy(BookSearchCriteria bookSearchCriteria);

}
