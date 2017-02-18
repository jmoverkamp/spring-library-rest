package pro.mynook.app.dao;

import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import pro.mynook.app.dto.OwnedBook;
import pro.mynook.app.factory.OwnedBookBuilder;
import pro.mynook.app.pojo.Book;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Jaxichael on 2/16/2017.
 */
public class BookDao implements BookDaoInterface {
    private final NamedParameterJdbcOperations jdbcOperations;

    private static final String GET_BOOKS = "SELECT b.title, bs.status_value\n" +
            "FROM owner_book ob\n" +
            "    JOIN book_status bs\n" +
            "        ON ob.status_id = bs.status_id\n" +
            "    JOIN book b\n" +
            "        ON ob.book_id = b.book_id\n" +
            "WHERE ob.owner_id = :ownerId AND ob.wishlist = :wishlist;";
    private static final String ADD_BOOK = "INSERT INTO book (book_id, isbn_10, isbn_13, title, authors, publisher, published_date, page_count, thumbnail)\n" +
            "VALUES (:bookId, :isbn10, :isbn13, :title, :authors, :publisher, :publishedDate, :pageCount, :thumbnail);";

    private static final String GET_STATUS = "SELECT status_value\n" +
            "FROM book_status;";

    public BookDao(@Nonnull final NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<OwnedBook> getBooks(String ownerId, Boolean wishlist) {
        RowMapper<OwnedBook> rowMapper = (ResultSet rs, int rowNum) -> {
            return new OwnedBookBuilder()
                    .setTitle(rs.getString("title"))
                    .setStatusValue(rs.getString("status_value"))
                    .build();
        };
        ImmutableMap<String, Object> mapping = ImmutableMap.of(
                "ownerId", ownerId,
                "wishlist", wishlist
        );
        return jdbcOperations.query(GET_BOOKS, mapping, rowMapper);
    }

    @Override
    public Integer addBook(Book request) {
        ImmutableMap mapping = ImmutableMap.builder()
            .put("bookId", request.getBookId())
            .put("isbn10", request.getIsbn10())
            .put("isbn13", request.getIsbn13())
            .put("title", request.getTitle())
            .put("authors", request.getAuthors())
            .put("publisher", request.getPublisher())
            .put("publishedDate", request.getPublishedDate())
            .put("pageCount", request.getPageCount())
            .put("thumbnail", request.getThumbnail())
            .build();
        return jdbcOperations.update(ADD_BOOK, mapping);
    }
}
