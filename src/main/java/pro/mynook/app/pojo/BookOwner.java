package pro.mynook.app.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Jaxichael on 2/17/2017.
 */
public class BookOwner {
    private String bookId;
    private String ownerId;
    private Boolean wishlist;

    public BookOwner() {
    }

    public BookOwner(String bookId, String ownerId, Boolean wishlist) {
        this.bookId = bookId;
        this.ownerId = ownerId;
        this.wishlist = wishlist;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Boolean getWishlist() {
        return wishlist;
    }

    public void setWishlist(Boolean wishlist) {
        this.wishlist = wishlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BookOwner bookOwner = (BookOwner) o;

        return new EqualsBuilder()
                .append(bookId, bookOwner.bookId)
                .append(ownerId, bookOwner.ownerId)
                .append(wishlist, bookOwner.wishlist)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(bookId)
                .append(ownerId)
                .append(wishlist)
                .toHashCode();
    }
}
