package org.lavlad.wslab;

import lombok.Data;
import org.lavlad.wslab.dataaccess.BookRepository;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

/**
 * Hello world!
 *
 */
@Data
@ApplicationScoped
public class AppConfig {

    @Resource(lookup = "java:comp/env/jdbc/books")
    private DataSource dataSource;

    @Produces
    public BookRepository getBookRepository() {
        return new BookRepository(dataSource);
    }

}
