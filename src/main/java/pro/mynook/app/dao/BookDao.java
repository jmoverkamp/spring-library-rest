package pro.mynook.app.dao;

import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import pro.mynook.app.dto.Book;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jaxichael on 2/16/2017.
 */
public class BookDao {
    private final NamedParameterJdbcOperations jdbcOperations;

    private static final String GET_BOOKS = "SELECT p.first_name, b.title " +
            "FROM person p " +
            "JOIN person_book pb ON p.person_api_key = pb.person_api_key " +
            "JOIN book b ON pb.book_api_key = b.book_api_key " +
            "WHERE p.person_api_key = :id";

    public BookDao(@Nonnull final NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public Book getBook(int bookId) { return null;}

    public List<Book> getBooks(int personId) {
        RowMapper<Book> rowMapper = (ResultSet rs, int rowNum) -> {
            return new Book(rs.getString("first_name"), rs.getString("title"));
        };

        return jdbcOperations.query(GET_BOOKS, ImmutableMap.of(
                "id", personId
        ), rowMapper);
    }

    public int addBook(Book book) {return -1;}
}
