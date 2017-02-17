package pro.mynook.app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.mynook.app.dao.BookDao;
import pro.mynook.app.dto.Book;
import pro.mynook.app.dto.BookGetRequest;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Jaxichael on 2/16/2017.
 */
@RestController
@RequestMapping("api/book")
public class BookController {
    @Nonnull
    private final BookDao bookDao;

    public BookController(@Nonnull final BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping(path = "getBooks",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks(@RequestBody final BookGetRequest request) {
        return bookDao.getBooks(request.getId());
    }

    @PostMapping(path = "getBook",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@RequestBody final BookGetRequest request) {
        return bookDao.getBook(request.getId());
    }

    @PostMapping(path = "addBook",  produces = MediaType.APPLICATION_JSON_VALUE)
    public int addBook(@RequestBody final BookGetRequest request) {
        return bookDao.addBook(new Book());
    }
}
