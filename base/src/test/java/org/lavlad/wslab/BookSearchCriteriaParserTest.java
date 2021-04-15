package org.lavlad.wslab;

import org.lavlad.wslab.dataaccess.BookRepository;
import org.lavlad.wslab.dataaccess.BookSearchCriteria;
import org.junit.Assert;
import org.junit.Test;

public class BookSearchCriteriaParserTest {

    @Test
    public void testEmptyCriteriaQuery() {

        String expectedQuery = "SELECT id, title, author, pages, synopsis FROM library;";

        String actualQuery = BookRepository.BookSearchCriteriaParser.getQueryFromCriteria(BookSearchCriteria.EMPTY_CRITERIA);

        Assert.assertEquals(expectedQuery, actualQuery);

    }

    @Test
    public void testCriteriaWithOneWhereIDClause() {

        String expectedQuery = "SELECT id, title, author, pages, synopsis FROM library WHERE id=42;";

        BookSearchCriteria criteria = new BookSearchCriteria(42L, null, null, null, null);

        String actualQuery = BookRepository.BookSearchCriteriaParser.getQueryFromCriteria(criteria);

        Assert.assertEquals(expectedQuery, actualQuery);

    }

    @Test
    public void testCriteriaWithIdAndNameClauses() {
        String expectedQuery = "SELECT id, title, author, pages, synopsis FROM library WHERE id=42 AND title='FOO';";

        BookSearchCriteria criteria = new BookSearchCriteria(42L, "FOO", null, null, null);

        String actualQuery = BookRepository.BookSearchCriteriaParser.getQueryFromCriteria(criteria);

        Assert.assertEquals(expectedQuery, actualQuery);

    }

}
