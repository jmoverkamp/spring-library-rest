package pro.mynook.app.factory;

import pro.mynook.app.pojo.Book;

/**
 * Created by Jaxichael on 2/17/2017.
 */
public class BookBuilder {
    private Book book;

    public BookBuilder() {
        this.book = new Book();
    }

    public BookBuilder setBookId(String bookId) {
        this.book.setBookId(bookId);
        return this;
    }

    public BookBuilder setIsbn10(String isbn10) {
        this.book.setIsbn10(isbn10);
        return this;
    }

    public BookBuilder setIsbn13(String isbn13) {
        this.book.setIsbn13(isbn13);
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.book.setTitle(title);
        return this;
    }

    public BookBuilder setAuthors(String authors) {
        this.book.setAuthors(authors);
        return this;
    }

    public BookBuilder setPublisher(String publisher) {
        this.book.setPublisher(publisher);
        return this;
    }

    public BookBuilder setPublishedDate(String publishedDate) {
        this.book.setPublishedDate(publishedDate);
        return this;
    }

    public BookBuilder setPageCount(Integer pageCount) {
        this.book.setPageCount(pageCount);
        return this;
    }

    public BookBuilder setThumbnail(String thumbnail) {
        this.book.setThumbnail(thumbnail);
        return this;
    }

    public Book build() {
        return book;
    }

}
