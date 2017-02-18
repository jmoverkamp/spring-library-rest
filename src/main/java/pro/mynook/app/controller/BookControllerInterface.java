package pro.mynook.app.controller;

import pro.mynook.app.pojo.Book;
import pro.mynook.app.dto.GetBooksRequest;
import pro.mynook.app.dto.OwnedBook;

import java.util.List;

/**
 * Created by Jaxichael on 2/17/2017.
 */
public interface BookControllerInterface {
    List<OwnedBook> getBooks(GetBooksRequest request);
    Integer addBook(Book request);
}
