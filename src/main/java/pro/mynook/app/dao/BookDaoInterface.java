package pro.mynook.app.dao;

import pro.mynook.app.dto.OwnedBook;
import pro.mynook.app.pojo.Book;

import java.util.List;

/**
 * Created by Jaxichael on 2/17/2017.
 */
public interface BookDaoInterface {
    List<OwnedBook> getBooks(String ownerId, Boolean wishlist);
    Integer addBook(Book request);
}
