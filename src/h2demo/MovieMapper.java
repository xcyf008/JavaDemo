package h2demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JavaDemo
 * h2demo
 * Created by timothy on 16/7/31.
 */
public class MovieMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {

        Movie movie = new Movie();
        movie.setId(rs.getInt("ID"));
        movie.setName(rs.getString("Name"));
        movie.setType(rs.getString("Type"));
        movie.setDescription(rs.getString("Description"));

        return movie;
    }
}
