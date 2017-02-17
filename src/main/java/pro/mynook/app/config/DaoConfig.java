package pro.mynook.app.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import pro.mynook.app.dao.BookDao;

import javax.sql.DataSource;

/**
 * Created by Jaxichael on 2/16/2017.
 */
@Configuration
public class DaoConfig {
    @Autowired
    private PropertyConfig propertyConfig;

    @Bean
    public BookDao bookDao() {
        return new BookDao(this.jdbcOperations());
    }

    @Bean
    public NamedParameterJdbcOperations jdbcOperations() {
        return new NamedParameterJdbcTemplate(this.dataSource());
    }

    @Bean
    public DataSource dataSource() {
        final MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(String.format("%s", this.propertyConfig.databaseUrl()));
        dataSource.setUser(this.propertyConfig.databaseUser());
        dataSource.setPassword(this.propertyConfig.databasePassword());
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }
}
