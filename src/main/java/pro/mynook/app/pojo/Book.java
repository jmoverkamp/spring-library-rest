package pro.mynook.app.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Jaxichael on 2/16/2017.
 */
public class Book {
    private String bookId;
    private String isbn10;
    private String isbn13;
    private String title;
    private String authors;
    private String publisher;
    private String publishedDate;
    private Integer pageCount;
    private String thumbnail;

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return new EqualsBuilder()
                .append(bookId, book.bookId)
                .append(isbn10, book.isbn10)
                .append(isbn13, book.isbn13)
                .append(title, book.title)
                .append(authors, book.authors)
                .append(publisher, book.publisher)
                .append(publishedDate, book.publishedDate)
                .append(pageCount, book.pageCount)
                .append(thumbnail, book.thumbnail)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(bookId)
                .append(isbn10)
                .append(isbn13)
                .append(title)
                .append(authors)
                .append(publisher)
                .append(publishedDate)
                .append(pageCount)
                .append(thumbnail)
                .toHashCode();
    }
}
