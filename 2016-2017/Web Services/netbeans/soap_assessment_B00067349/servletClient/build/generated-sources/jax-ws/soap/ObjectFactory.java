
package soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap package. 
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

    private final static QName _AddBook_QNAME = new QName("http://soap/", "addBook");
    private final static QName _AddBookResponse_QNAME = new QName("http://soap/", "addBookResponse");
    private final static QName _DisplayBook_QNAME = new QName("http://soap/", "displayBook");
    private final static QName _DisplayBookResponse_QNAME = new QName("http://soap/", "displayBookResponse");
    private final static QName _RemoveBook_QNAME = new QName("http://soap/", "removeBook");
    private final static QName _RemoveBookResponse_QNAME = new QName("http://soap/", "removeBookResponse");
    private final static QName _UpdateBook_QNAME = new QName("http://soap/", "updateBook");
    private final static QName _UpdateBookResponse_QNAME = new QName("http://soap/", "updateBookResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddBook }
     * 
     */
    public AddBook createAddBook() {
        return new AddBook();
    }

    /**
     * Create an instance of {@link AddBookResponse }
     * 
     */
    public AddBookResponse createAddBookResponse() {
        return new AddBookResponse();
    }

    /**
     * Create an instance of {@link DisplayBook }
     * 
     */
    public DisplayBook createDisplayBook() {
        return new DisplayBook();
    }

    /**
     * Create an instance of {@link DisplayBookResponse }
     * 
     */
    public DisplayBookResponse createDisplayBookResponse() {
        return new DisplayBookResponse();
    }

    /**
     * Create an instance of {@link RemoveBook }
     * 
     */
    public RemoveBook createRemoveBook() {
        return new RemoveBook();
    }

    /**
     * Create an instance of {@link RemoveBookResponse }
     * 
     */
    public RemoveBookResponse createRemoveBookResponse() {
        return new RemoveBookResponse();
    }

    /**
     * Create an instance of {@link UpdateBook }
     * 
     */
    public UpdateBook createUpdateBook() {
        return new UpdateBook();
    }

    /**
     * Create an instance of {@link UpdateBookResponse }
     * 
     */
    public UpdateBookResponse createUpdateBookResponse() {
        return new UpdateBookResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addBook")
    public JAXBElement<AddBook> createAddBook(AddBook value) {
        return new JAXBElement<AddBook>(_AddBook_QNAME, AddBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addBookResponse")
    public JAXBElement<AddBookResponse> createAddBookResponse(AddBookResponse value) {
        return new JAXBElement<AddBookResponse>(_AddBookResponse_QNAME, AddBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "displayBook")
    public JAXBElement<DisplayBook> createDisplayBook(DisplayBook value) {
        return new JAXBElement<DisplayBook>(_DisplayBook_QNAME, DisplayBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "displayBookResponse")
    public JAXBElement<DisplayBookResponse> createDisplayBookResponse(DisplayBookResponse value) {
        return new JAXBElement<DisplayBookResponse>(_DisplayBookResponse_QNAME, DisplayBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "removeBook")
    public JAXBElement<RemoveBook> createRemoveBook(RemoveBook value) {
        return new JAXBElement<RemoveBook>(_RemoveBook_QNAME, RemoveBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "removeBookResponse")
    public JAXBElement<RemoveBookResponse> createRemoveBookResponse(RemoveBookResponse value) {
        return new JAXBElement<RemoveBookResponse>(_RemoveBookResponse_QNAME, RemoveBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "updateBook")
    public JAXBElement<UpdateBook> createUpdateBook(UpdateBook value) {
        return new JAXBElement<UpdateBook>(_UpdateBook_QNAME, UpdateBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "updateBookResponse")
    public JAXBElement<UpdateBookResponse> createUpdateBookResponse(UpdateBookResponse value) {
        return new JAXBElement<UpdateBookResponse>(_UpdateBookResponse_QNAME, UpdateBookResponse.class, null, value);
    }

}
