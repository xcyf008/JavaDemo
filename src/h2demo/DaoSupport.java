package h2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JavaDemo
 * h2demo
 * Created by timothy on 16/8/1.
 */
public class DaoSupport {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected MovieSql movieSql;
}
