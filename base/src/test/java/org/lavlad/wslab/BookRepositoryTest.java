package org.lavlad.wslab;

import org.lavlad.wslab.dataaccess.BookRepository;
import org.lavlad.wslab.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookRepositoryTest {

    private static final Long id = 42L;
    private static final String title = "FOO";
    private static final String author = "BAR";
    private static final Long pages = 42L;
    private static final String synopsis = "FOOBAR";

    @Test
    public void testGetBooks() throws SQLException {

        DataSource mockedDataSource = getDataSource();

        Book expectedBook = new Book(id, title, author, pages, synopsis);

        BookRepository repository = new BookRepository(mockedDataSource);

        Assert.assertArrayEquals(new Book[]{expectedBook}, repository.getBooks().toArray());

    }

    private DataSource getDataSource() throws SQLException {

        Connection mockedConnection = getMockedConnection();

        DataSource dataSource = Mockito.mock(DataSource.class);

        Mockito.when(dataSource.getConnection()).thenReturn(mockedConnection);

        return dataSource;

    }

    private Connection getMockedConnection() throws SQLException {

        Statement mockedStatement = getMockedStatement();

        Connection mockedConnection = Mockito.mock(Connection.class);

        Mockito.when(mockedConnection.createStatement()).thenReturn(mockedStatement);

        return mockedConnection;

    }

    private Statement getMockedStatement() throws SQLException {

        ResultSet mockedResultSet = getMockResultSet();

        Statement mockedStatement = Mockito.mock(Statement.class);

        Mockito.when(mockedStatement.getResultSet()).thenReturn(mockedResultSet);

        return mockedStatement;
    }

    private ResultSet getMockResultSet() throws SQLException {

        ResultSet mockedResultSet = Mockito.mock(ResultSet.class);

        Mockito.when(mockedResultSet.next()).thenReturn(true).thenReturn(false);

        Mockito.when(mockedResultSet.getLong("id")).thenReturn(id);

        Mockito.when(mockedResultSet.getString("title")).thenReturn(title);

        Mockito.when(mockedResultSet.getString("author")).thenReturn(author);

        Mockito.when(mockedResultSet.getLong("pages")).thenReturn(pages);

        Mockito.when(mockedResultSet.getString("synopsis")).thenReturn(synopsis);

        return mockedResultSet;
    }

}
