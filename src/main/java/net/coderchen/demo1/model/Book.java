package net.coderchen.demo1.model;

public class Book {
    private Integer bookId;

    private String bookName;

    private Long bookMoney;

    private Integer leftCount;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Long getBookMoney() {
        return bookMoney;
    }

    public void setBookMoney(Long bookMoney) {
        this.bookMoney = bookMoney;
    }

    public Integer getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(Integer leftCount) {
        this.leftCount = leftCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookMoney=" + bookMoney +
                ", leftCount=" + leftCount +
                '}';
    }
}