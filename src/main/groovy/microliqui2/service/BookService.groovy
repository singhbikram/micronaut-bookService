package microliqui2.service

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import microliqui2.domain.Book
import org.grails.datastore.mapping.validation.ValidationException

@Slf4j
@Singleton
@Transactional
class BookService {

    Book create(Map data) throws ValidationException {
        Book book = new Book();
        String bookId = data.get("bookId")
        String name = data.get("name")
        String author = data.get("author")
        String genre = data.get("genre")

        book.setBookId(bookId)
        book.setName(name)
        book.setAuthor(author)
        book.setGenre(genre)
        book = book.save(flush:true)
        book
    }

    // find all the books
    Object get()
    {
        Book.findAll()
    }


}
