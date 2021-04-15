package org.lavlad.wslab;

import org.lavlad.wslab.dataaccess.BookRepository;
import org.lavlad.wslab.service.BookService;
import org.postgresql.ds.PGSimpleDataSource;

import javax.xml.ws.Endpoint;

public class App 
{
    public static void main( String[] args )
    {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setDatabaseName("wslab");
        ds.setUser("wsadmin");
        ds.setPassword("wspass");
        ds.setServerName("wslab-database");
        BookRepository repository = new BookRepository(ds);
        BookService service = new BookService(repository);
        Endpoint.publish("http://0.0.0.0:8080/wslab-server/BookWebService", service);
    }
}
