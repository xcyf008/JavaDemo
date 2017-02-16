package ignitedemo;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

/**
 * JavaDemo
 * ignitedemo
 * Created by timothy on 16/8/22.
 */
public class Student implements Serializable {

    @QuerySqlField(index = true)
    private String id;

    @QuerySqlField(index = true)
    private String name;

    @QuerySqlField(index = true)
    private int grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {

        return String.format("ID = %s; Name = %s; Grade = %s;",
                getId(), getName(), getGrade());
    }
}
