
package org.lavlad.wslab.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.lavlad.wslab.service package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteBookById_QNAME = new QName("http://service.wslab.lavlad.org/", "deleteBookById");
    private final static QName _CreateBookResponse_QNAME = new QName("http://service.wslab.lavlad.org/", "createBookResponse");
    private final static QName _UpdateBook_QNAME = new QName("http://service.wslab.lavlad.org/", "updateBook");
    private final static QName _CreateBook_QNAME = new QName("http://service.wslab.lavlad.org/", "createBook");
    private final static QName _GetBooksResponse_QNAME = new QName("http://service.wslab.lavlad.org/", "getBooksResponse");
    private final static QName _GetBooks_QNAME = new QName("http://service.wslab.lavlad.org/", "getBooks");
    private final static QName _DeleteBookByIdResponse_QNAME = new QName("http://service.wslab.lavlad.org/", "deleteBookByIdResponse");
    private final static QName _UpdateBookResponse_QNAME = new QName("http://service.wslab.lavlad.org/", "updateBookResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.lavlad.wslab.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteBookById }
     * 
     */
    public DeleteBookById createDeleteBookById() {
        return new DeleteBookById();
    }

    /**
     * Create an instance of {@link CreateBookResponse }
     * 
     */
    public CreateBookResponse createCreateBookResponse() {
        return new CreateBookResponse();
    }

    /**
     * Create an instance of {@link UpdateBook }
     * 
     */
    public UpdateBook createUpdateBook() {
        return new UpdateBook();
    }

    /**
     * Create an instance of {@link CreateBook }
     * 
     */
    public CreateBook createCreateBook() {
        return new CreateBook();
    }

    /**
     * Create an instance of {@link GetBooksResponse }
     * 
     */
    public GetBooksResponse createGetBooksResponse() {
        return new GetBooksResponse();
    }

    /**
     * Create an instance of {@link GetBooks }
     * 
     */
    public GetBooks createGetBooks() {
        return new GetBooks();
    }

    /**
     * Create an instance of {@link DeleteBookByIdResponse }
     * 
     */
    public DeleteBookByIdResponse createDeleteBookByIdResponse() {
        return new DeleteBookByIdResponse();
    }

    /**
     * Create an instance of {@link UpdateBookResponse }
     * 
     */
    public UpdateBookResponse createUpdateBookResponse() {
        return new UpdateBookResponse();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBookById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wslab.lavlad.org/", name = "deleteBookById")
    public JAXBElement<DeleteBookById> createDeleteBookById(DeleteBookById value) {
        return new JAXBElement<DeleteBookById>(_DeleteBookById_QNAME, DeleteBookById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wslab.lavlad.org/", name = "createBookResponse")
    public JAXBElement<CreateBookResponse> createCreateBookResponse(CreateBookResponse value) {
        return new JAXBElement<CreateBookResponse>(_CreateBookResponse_QNAME, CreateBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wslab.lavlad.org/", name = "updateBook")
    public JAXBElement<UpdateBook> createUpdateBook(UpdateBook value) {
        return new JAXBElement<UpdateBook>(_UpdateBook_QNAME, UpdateBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wslab.lavlad.org/", name = "createBook")
    public JAXBElement<CreateBook> createCreateBook(CreateBook value) {
        return new JAXBElement<CreateBook>(_CreateBook_QNAME, CreateBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wslab.lavlad.org/", name = "getBooksResponse")
    public JAXBElement<GetBooksResponse> createGetBooksResponse(GetBooksResponse value) {
        return new JAXBElement<GetBooksResponse>(_GetBooksResponse_QNAME, GetBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wslab.lavlad.org/", name = "getBooks")
    public JAXBElement<GetBooks> createGetBooks(GetBooks value) {
        return new JAXBElement<GetBooks>(_GetBooks_QNAME, GetBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBookByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wslab.lavlad.org/", name = "deleteBookByIdResponse")
    public JAXBElement<DeleteBookByIdResponse> createDeleteBookByIdResponse(DeleteBookByIdResponse value) {
        return new JAXBElement<DeleteBookByIdResponse>(_DeleteBookByIdResponse_QNAME, DeleteBookByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wslab.lavlad.org/", name = "updateBookResponse")
    public JAXBElement<UpdateBookResponse> createUpdateBookResponse(UpdateBookResponse value) {
        return new JAXBElement<UpdateBookResponse>(_UpdateBookResponse_QNAME, UpdateBookResponse.class, null, value);
    }

}
