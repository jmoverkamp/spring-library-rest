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
    @Nonnull
    private final NamedParameterJdbcOperations jdbcOperations;

    private static final String GET_BOOKS = "SELECT p.first_name, b.title " +
            "FROM person p " +
            "JOIN person_book pb ON p.person_api_key = pb.person_api_key " +
            "JOIN book b ON pb.book_api_key = b.book_api_key " +
            "WHERE p.person_api_key = :id";

    public BookDao(@Nonnull final NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Nonnull
    public List<Book> get(int id) {
        RowMapper<Book> rowMapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(rs.getString("first_name"), rs.getString("title"));
            }
        };
        ImmutableMap<String, Object> map = ImmutableMap.of(
                "id", id
        );
        return jdbcOperations.query(GET_BOOKS, map, rowMapper);
    }
}
