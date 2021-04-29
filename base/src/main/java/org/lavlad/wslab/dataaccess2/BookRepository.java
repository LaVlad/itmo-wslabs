package org.lavlad.wslab.dataaccess2;

import org.lavlad.wslab.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>, BookGETRepository {
}
