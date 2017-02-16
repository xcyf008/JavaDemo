package h2demo;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * JavaDemo
 * h2demo
 * Created by timothy on 16/8/1.
 */
public class MovieDaoImp2 extends SqlSessionDaoSupport implements MovieDao {

    @Override
    public List<Movie> getAllMovie() {

        return getSqlSession().selectList("getAllMovies");
    }
}
