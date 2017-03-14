package pro.mynook.app.dao;

import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import pro.mynook.app.dto.BookOwnerRequest;
import pro.mynook.app.dto.OwnedBook;
import pro.mynook.app.factory.OwnedBookBuilder;
import pro.mynook.app.pojo.Book;
import pro.mynook.app.pojo.BookOwner;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Jaxichael on 2/16/2017.
 */
public class BookDao implements BookDaoInterface {
    private final NamedParameterJdbcOperations jdbcOperations;
    private static final String GET_BOOKS = "SELECT *\n" +
            "FROM owner_book ob\n" +
            "    JOIN book_status bs\n" +
            "        ON ob.status_id = bs.status_id\n" +
            "    JOIN book b\n" +
            "        ON ob.book_id = b.book_id\n" +
            "WHERE ob.owner_id = :ownerId AND ob.wishlist = :wishlist;";

    private static final String ADD_BOOK = "INSERT INTO book (book_id, isbn_10, isbn_13, title, authors, publisher, published_date, page_count, thumbnail)\n" +
            "VALUES (:bookId, :isbn10, :isbn13, :title, :authors, :publisher, :publishedDate, :pageCount, :thumbnail);";
    private static final String DELETE_BOOK_OWNER = "DELETE FROM owner_book \n" +
            "WHERE owner_id = :ownerId AND book_id = :bookId;";
    private static final String ADD_BOOK_OWNER = "INSERT INTO owner_book (owner_id, book_id, wishlist) \n" +
            "VALUES (:ownerId, :bookId, :wishlist);";
    private static final String UPDATE_BOOK_OWNER = "UPDATE owner_book SET wishlist = :wishlist\n" +
            "WHERE owner_id = :ownerId AND book_id = :bookId";
    private static final String GET_STATUS = "SELECT status_value\n" +
            "FROM book_status;";


    public BookDao(@Nonnull final NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<OwnedBook> getBooks(String ownerId, Boolean wishlist) {
        RowMapper<OwnedBook> rowMapper = (ResultSet rs, int rowNum) -> {
            return new OwnedBookBuilder()
                    .setBookId(rs.getString("book_id"))
                    .setIsbn10(rs.getString("isbn_10"))
                    .setIsbn13(rs.getString("isbn_13"))
                    .setTitle(rs.getString("title"))
                    .setAuthors(rs.getString("authors"))
                    .setPublisher(rs.getString("publisher"))
                    .setPublishedDate(rs.getString("published_date"))
                    .setPageCount(rs.getInt("page_count"))
                    .setThumbnail(rs.getString("thumbnail"))
                    .setStatusValue(rs.getString("status_value"))
                    .setWishlist(rs.getString("wishlist"))
                    .setRating(rs.getInt("rating"))
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

    @Override
    public Integer deleteBookOwner(String ownerId, String bookId) {
        ImmutableMap<String, Object> mapping = ImmutableMap.of(
                "ownerId", ownerId,
                "bookId", bookId
        );
        return jdbcOperations.update(DELETE_BOOK_OWNER, mapping);
    }

    @Override
    public Integer addBookOwner(BookOwner request) {
        ImmutableMap mapping = ImmutableMap.builder()
                .put("bookId", request.getBookId())
                .put("ownerId", request.getOwnerId())
                .put("wishlist", request.getWishlist())
                .build();
        return jdbcOperations.update(ADD_BOOK_OWNER, mapping);
    }

    @Override
    public Integer updateBookOwner(BookOwnerRequest request) {
        ImmutableMap mapping = ImmutableMap.builder()
                .put("bookId", request.getBookId())
                .put("ownerId", request.getOwnerId())
                .put("wishlist", request.getWishlist())
                .build();
        return jdbcOperations.update(UPDATE_BOOK_OWNER, mapping);
    }
}
