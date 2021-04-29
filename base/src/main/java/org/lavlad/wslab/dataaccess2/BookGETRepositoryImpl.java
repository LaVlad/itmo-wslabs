package org.lavlad.wslab.dataaccess2;

import lombok.Getter;
import lombok.Setter;
import org.lavlad.wslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BookGETRepositoryImpl implements BookGETRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getBooksBy(BookSearchCriteria bookSearchCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> books = query.from(Book.class);

        List<Predicate> predicates = new ArrayList<>();

        bookSearchCriteria.getId().ifPresent(id -> {
            predicates.add(cb.equal(books.get("id"), id));
        });

        bookSearchCriteria.getTitle().ifPresent(title -> {
            predicates.add(cb.equal(books.get("title"), title));
        });

        bookSearchCriteria.getAuthor().ifPresent(author -> {
            predicates.add(cb.equal(books.get("author"), author));
        });

        bookSearchCriteria.getPages().ifPresent(pages ->{
            predicates.add(cb.equal(books.get("pages"), pages));
        });

        bookSearchCriteria.getSynopsis().ifPresent(synopsis -> {
            predicates.add(cb.equal(books.get("synopsis"), synopsis));
        });

        query.select(books).where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(query).getResultList();
    }

}
