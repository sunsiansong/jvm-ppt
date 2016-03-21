package foo.domain;

import java.util.Date;

/**
 * Created by sunxiansong on 16/3/6.
 */
public class User {
    private String name;
    private Integer age;
    private String gender;
    private Date createDate;

    public User(String name, Integer age, String gender, Date createDate){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
