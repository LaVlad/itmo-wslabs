package org.lavlad.wslab.dataaccess;

import org.lavlad.wslab.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class BookRepository {

    private static final Logger log = LoggerFactory.getLogger(BookRepository.class);

    private final DataSource dataSource;

    public BookRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Book> getBooks() {
        return searchByCriteria(BookSearchCriteria.EMPTY_CRITERIA);
    }

    public List<Book> searchByCriteria(BookSearchCriteria bookSearchCriteria) {
        log.info("search by criteria: {}", bookSearchCriteria);
        try(Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            String query = BookSearchCriteriaParser.getQueryFromCriteria(bookSearchCriteria);

            statement.execute(query);

            ResultSet resultSet = statement.getResultSet();

            return getBookListFromResultSet(resultSet);

        } catch (SQLException throwables) {
            log.error("error during database lookup");
            return Collections.emptyList();
        }
    }

    public Long createBook(String title, String author, Long pages, String synopsis) {
        log.info("create book [title: {}, author: {}, pages: {}, synopsis: {}]",
                title,
                author,
                pages,
                synopsis
        );
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(BookSearchCriteriaParser.CREATE_STATEMENT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setLong(3, pages);
            if (synopsis == null) {
                statement.setNull(4, Types.VARCHAR);
            } else {
                statement.setString(4, synopsis);
            }
            int affectedRows = statement.executeUpdate();
            if (affectedRows != 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Failed to create book, no ID obtained");
                }
            }
        } catch (SQLException throwables) {
            log.error("error during create operation");
            throwables.printStackTrace();
        }
        return -1L;
    }

    public boolean deleteBookById(Long id) {
        log.info("deleting book: {}", id);

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(BookSearchCriteriaParser.DELETE_STATEMENT);

            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public boolean updateBook(Book bookUpdate) {
        log.info("updating book: {}", bookUpdate);

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(BookSearchCriteriaParser.UPDATE_STATEMENT);

            preparedStatement.setString(1, bookUpdate.getTitle());
            preparedStatement.setString(2, bookUpdate.getAuthor());
            preparedStatement.setLong(3, bookUpdate.getPages());
            if (bookUpdate.getSynopsis() == null) {
                preparedStatement.setNull(4, Types.VARCHAR);
            } else {
                preparedStatement.setString(4, bookUpdate.getSynopsis());
            }
            preparedStatement.setLong(5, bookUpdate.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    private List<Book> getBookListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();

        while (resultSet.next()) {
            books.add(getBookFromResultSet(resultSet));
        }

        return books;
    }

    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(BookSearchCriteriaParser.ID);
        String title = resultSet.getString(BookSearchCriteriaParser.TITLE);
        String author = resultSet.getString(BookSearchCriteriaParser.AUTHOR);
        Long pages = resultSet.getLong(BookSearchCriteriaParser.PAGES);
        String synopsis = resultSet.getString(BookSearchCriteriaParser.SYNOPSIS);
        return new Book(id, title, author, pages, synopsis);
    }

    public static class BookSearchCriteriaParser {

        private static final String ID = "id";

        private static final String TITLE = "title";

        private static final String AUTHOR = "author";

        private static final String PAGES = "pages";

        private static final String SYNOPSIS = "synopsis";

        private static final String[] selectors = new String[]{ID, TITLE, AUTHOR, PAGES, SYNOPSIS};

        private static final String QUERY_TEMPLATE = "SELECT %s FROM library%s";

        public static final String CREATE_STATEMENT = "INSERT INTO library VALUES (DEFAULT, ?, ?, ?, ?);";

        public static final String DELETE_STATEMENT = "DELETE FROM library WHERE id=?;";

        public static final String UPDATE_STATEMENT = "UPDATE library SET title=?, author=?, pages=?, synopsis=? WHERE id=?;";

        public static String getQueryFromCriteria(BookSearchCriteria criteria) {

            String selectors = getSelectorClause();

            String whereClause = getWhereClause(criteria);

            return String.format(QUERY_TEMPLATE, selectors, whereClause);
        }

        private static String getSelectorClause() {
            StringJoiner selectJoiner = new StringJoiner(", ");

            Arrays.stream(selectors).forEach(selectJoiner::add);

            return selectJoiner.toString();
        }

        private static String getWhereClause(BookSearchCriteria criteria) {
            if (criteria.isEmptyCriteria()) {
                return ";";
            }
            StringJoiner whereClauseJoiner = new StringJoiner(" AND ", " WHERE ", ";");

            String whereClauseTemplate = "%s=%s";
            String stringWhereClauseTemplate = "%s='%s'";

            if (criteria.getId() != null) {
                whereClauseJoiner.add(String.format(whereClauseTemplate, ID, criteria.getId()));
            }

            if (criteria.getTitle() != null) {
                whereClauseJoiner.add(String.format(stringWhereClauseTemplate, TITLE, criteria.getTitle()));
            }

            if (criteria.getAuthor() != null) {
                whereClauseJoiner.add(String.format(stringWhereClauseTemplate, AUTHOR, criteria.getAuthor()));
            }

            if (criteria.getPages() != null) {
                whereClauseJoiner.add(String.format(whereClauseTemplate, PAGES, criteria.getPages()));
            }

            if (criteria.getSynopsis() != null) {
                whereClauseJoiner.add(String.format(stringWhereClauseTemplate, SYNOPSIS, criteria.getSynopsis()));
            }

            return whereClauseJoiner.toString();
        }

    }

}
