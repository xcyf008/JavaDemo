package h2demo;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * JavaDemo
 * h2demo
 * Created by timothy on 16/7/28.
 */
public class H2DemoApp {

    private final static String JDBC_URL = "jdbc:h2:tcp://localhost/~/database/h2/data/demo";
    private final static String DB_USER = "sa";
    private final static String DB_PWD = "";
    private final static String DB_DRIVER_CLASS = "org.h2.Driver";

    private final static String SQL_GET_MOVIES = "select ID, Name, Type, Description from Movie";
    private final static String SQL_INSERT_MOVIE = "";

    public static void main(String[] args) throws SQLException {

        queryWithMybatis();

    }

    private static void queryWithDataSource() {

        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/spring-ioc.xml")) {
            JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
            List<Movie> movies = template.query(SQL_GET_MOVIES, new MovieMapper());
            for (Movie m : movies) {
                System.out.println("============");
                System.out.println("ID: " + m.getId());
                System.out.println("Name: " + m.getName());
                System.out.println("Type: " + m.getType());
                System.out.println("Descripton: " + m.getDescription());
            }
        }
    }

    private static void printDataSourceProperty(DataSource dataSource) {

        if (dataSource == null) {

            System.out.println("URL = " + dataSource.getUrl());
            System.out.println("Driver Class Name = " + dataSource.getDriverClassName());
            System.out.println("User Name = " + dataSource.getUsername());
            System.out.println("Password = " + dataSource.getPassword());
            System.out.println("Max Active Connection = " + dataSource.getMaxActive());
            System.out.println("Min Idle Connection = " + dataSource.getMinIdle());
            System.out.println("Max Idel Connection = " + dataSource.getMaxIdle());
        }
    }

    private static void queryWithJdbcTemplate() throws SQLException {

        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/spring-ioc.xml")){

            DataSource dataSource = context.getBean("dataSource", DataSource.class);

            if (dataSource != null) {
                printDataSourceProperty(dataSource);
                try(Connection connection = dataSource.getConnection()) {
                    try(Statement stmt = connection.createStatement()) {
                        ResultSet rows = stmt.executeQuery(SQL_GET_MOVIES);
                        while (rows.next()) {
                            System.out.println("==============");
                            System.out.println("Movie ID: " + rows.getString("ID"));
                            System.out.println("Movie Name: " + rows.getString("Name"));
                            System.out.println("Movie Type: " + rows.getString("Type"));
                            System.out.println("Movie Description: " + rows.getString("Description"));
                        }
                    }
                }
                dataSource.close();

            } else {

                System.out.println("DataSource is not initialized");
            }

        }

    }

    private static void queryWithMybatis() throws SQLException {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/spring-ioc.xml")) {
            MovieDaoImp2 movieDaoImp2 = context.getBean("movieDao2", MovieDaoImp2.class);
            List<Movie> movies = movieDaoImp2.getAllMovie();
            movies.forEach(i -> {
                System.out.println("Movie Name: " + i.getName());
            });
        }
    }
}
