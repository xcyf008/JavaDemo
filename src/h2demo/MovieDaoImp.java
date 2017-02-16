package h2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * JavaDemo
 * h2demo
 * Created by timothy on 16/8/1.
 */
public class MovieDaoImp extends DaoSupport implements MovieDao {

    private final static String SQL_GET_MOVIES = "select ID, Name, Type, Description from Movie";

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAllMovie() {

        return jdbcTemplate.query(movieSql.queryAllMovieSql, new MovieMapper());
    }
}
