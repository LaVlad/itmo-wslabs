package org.lavlad.wslab;

import org.lavlad.wslab.dataaccess.BookSearchCriteria;
import org.junit.Assert;
import org.junit.Test;

public class BookSearchCriteriaTest {

    @Test
    public void testEmptyCriteriaIsEmpty() {
        Assert.assertTrue(BookSearchCriteria.EMPTY_CRITERIA.isEmptyCriteria());
    }

    @Test
    public void testCriteriaWithNullsEmpty() {
        BookSearchCriteria emptyCriteria = new BookSearchCriteria(null, null, null, null, null);

        Assert.assertTrue(emptyCriteria.isEmptyCriteria());
    }

    @Test
    public void testCriteriaWithIdNotEmpty() {
        BookSearchCriteria criteria = new BookSearchCriteria(42L, null, null, null, null);

        Assert.assertFalse(criteria.isEmptyCriteria());
    }

}
