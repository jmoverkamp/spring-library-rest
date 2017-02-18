package pro.mynook.app.factory;

import pro.mynook.app.dto.OwnedBook;

/**
 * Created by Jaxichael on 2/17/2017.
 */
public class OwnedBookBuilder {
    private OwnedBook ownedBook;

    public OwnedBookBuilder() {
        this.ownedBook = new OwnedBook();
    }

    public OwnedBookBuilder setBookId(String bookId) {
        this.ownedBook.setBookId(bookId);
        return this;
    }

    public OwnedBookBuilder setIsbn10(String isbn10) {
        this.ownedBook.setIsbn10(isbn10);
        return this;
    }

    public OwnedBookBuilder setIsbn13(String isbn13) {
        this.ownedBook.setIsbn13(isbn13);
        return this;
    }

    public OwnedBookBuilder setTitle(String title) {
        this.ownedBook.setTitle(title);
        return this;
    }

    public OwnedBookBuilder setAuthors(String authors) {
        this.ownedBook.setAuthors(authors);
        return this;
    }

    public OwnedBookBuilder setPublisher(String publisher) {
        this.ownedBook.setPublisher(publisher);
        return this;
    }

    public OwnedBookBuilder setPublishedDate(String publishedDate) {
        this.ownedBook.setPublishedDate(publishedDate);
        return this;
    }

    public OwnedBookBuilder setPageCount(Integer pageCount) {
        this.ownedBook.setPageCount(pageCount);
        return this;
    }

    public OwnedBookBuilder setThumbnail(String thumbnail) {
        this.ownedBook.setThumbnail(thumbnail);
        return this;
    }

    public OwnedBookBuilder setStatusValue(String statusValue) {
        this.ownedBook.setStatusValue(statusValue);
        return this;
    }

    public OwnedBookBuilder setRating(Integer rating) {
        this.ownedBook.setRating(rating);
        return this;
    }

    public OwnedBookBuilder setWishlist(String wishlist) {
        this.ownedBook.setWishlist(wishlist);
        return this;
    }

    public OwnedBook build() {
        return ownedBook;
    }

}
