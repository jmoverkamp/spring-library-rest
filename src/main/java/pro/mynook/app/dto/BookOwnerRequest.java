package pro.mynook.app.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Jaxichael on 3/13/2017.
 */
public class BookOwnerRequest {
    private String ownerId;
    private String bookId;
    private String wishlist;

    public BookOwnerRequest() {
    }

    public BookOwnerRequest(String ownerId, String bookId, String wishlist) {
        this.ownerId = ownerId;
        this.bookId = bookId;
        this.wishlist = wishlist;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getWishlist() {
        return wishlist;
    }

    public void setWishlist(String wishlist) {
        this.wishlist = wishlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BookOwnerRequest that = (BookOwnerRequest) o;

        return new EqualsBuilder()
                .append(ownerId, that.ownerId)
                .append(bookId, that.bookId)
                .append(wishlist, that.wishlist)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(ownerId)
                .append(bookId)
                .append(wishlist)
                .toHashCode();
    }
}
