package com.atguigu.bean;

/**
 * @author ccstart
 * @create 2022-04-26 16:25
 */
public class Book {

    private String bookName;
    private Integer bookId;
    private String sex;
    private Integer age;
    private String email;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Book(String bookName, Integer bookId, String sex, Integer age, String email) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookId=" + bookId +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public Book() {
    }
}
