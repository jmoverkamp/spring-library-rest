package pro.mynook.app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.mynook.app.dao.BookDao;
import pro.mynook.app.dto.DeleteBookOwnerRequest;
import pro.mynook.app.pojo.Book;
import pro.mynook.app.dto.GetBooksRequest;
import pro.mynook.app.dto.OwnedBook;
import pro.mynook.app.pojo.BookOwner;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Jaxichael on 2/16/2017.
 */
@RestController
@CrossOrigin
@RequestMapping("api/book")
public class BookController implements BookControllerInterface {
    @Nonnull
    private final BookDao bookDao;

    public BookController(@Nonnull final BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @PostMapping(path = "getBooks",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OwnedBook> getBooks(@RequestBody final GetBooksRequest request) {
        return bookDao.getBooks(request.getOwnerId(), request.getWishlist());
    }

    @Override
    @PostMapping(path = "addBook",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer addBook(@RequestBody final Book request) {
        return bookDao.addBook(request);
    }

    @Override
    @PostMapping(path = "deleteBookOwner",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer deleteBookOwner(@RequestBody DeleteBookOwnerRequest request) {
        return bookDao.deleteBookOwner(request.getOwnerId(), request.getBookId());
    }

    @Override
    @PostMapping(path = "addBookOwner",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer addBookOwner(@RequestBody BookOwner request) {
        return bookDao.addBookOwner(request);
    }

//    @PostMapping(path = "getBook",  produces = MediaType.APPLICATION_JSON_VALUE)
//    public Book getBook(@RequestBody final GetBooksRequest request) {
//        return bookDao.getBook(request.getId());
//    }

//    @PostMapping(path = "addBook",  produces = MediaType.APPLICATION_JSON_VALUE)
//    public int addBook(@RequestBody final GetBooksRequest request) {
//        return bookDao.addBook(new Book());
//    }
}
