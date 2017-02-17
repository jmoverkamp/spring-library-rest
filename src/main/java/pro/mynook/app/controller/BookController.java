package pro.mynook.app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.mynook.app.dao.BookDao;
import pro.mynook.app.dto.Book;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Jaxichael on 2/16/2017.
 */
@RestController
@RequestMapping("book")
public class BookController {
    @Nonnull
    private final BookDao bookDao;

    public BookController(@Nonnull final BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping(path = "get",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> get() {
        return bookDao.get();
    }

}
