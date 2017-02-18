package pro.mynook.app.dao;

import pro.mynook.app.dto.GetBooksRequest;
import pro.mynook.app.dto.OwnedBook;
import pro.mynook.app.pojo.Book;
import pro.mynook.app.pojo.BookOwner;

import java.util.List;

/**
 * Created by Jaxichael on 2/17/2017.
 */
public interface BookDaoInterface {
    List<OwnedBook> getBooks(String ownerId, Boolean wishlist);
    Integer addBook(Book request);
    Integer deleteBookOwner(String ownerId, String bookId);
    Integer addBookOwner(BookOwner request);
}
