package microliqui2.controller

import groovy.cli.Option
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.reactivex.Single
import microliqui2.domain.Book
import microliqui2.service.BookService

import javax.annotation.Nullable
import javax.inject.Inject
import javax.validation.ValidationException

@Slf4j
@Controller("/")
@CompileStatic
class BookController {

    @Inject BookService bookService;

    @Get("/hello/{name}")
    String index(String name){
        log.info ">>> inside the index method "
        return "hello $name"
    }

    @Post('/')
    Single<Map> create(@Body Map data)
    {
        log.info (">>>> save book request received. Updating  data = {}",  data)
        Book book = bookService.create(data)
        log.info ">>>> save book request is being processed ..."
        success(data)
//
    }
    Single<Map> success(Object result=null) {
        Single.just((Map)[success: true, result: result])
    }

    @Get('/getBooks')
     Single<Map> get() {
        log.info("Fetching books...{}", bookService.get())
        success(bookService.get())
    }


}
