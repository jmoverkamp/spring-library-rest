package pro.mynook.app.dao;

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
    @Nonnull
    private final NamedParameterJdbcOperations jdbcOperations;

    private static final String GET_BOOKS = "SELECT * FROM book";

    public BookDao(@Nonnull final NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Nonnull
    public List<Book> get() {
        return jdbcOperations.query(GET_BOOKS, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(rs.getInt("book_api_key"), rs.getString("title"));
            }
        });
    }
}
