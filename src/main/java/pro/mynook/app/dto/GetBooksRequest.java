package pro.mynook.app.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Jaxichael on 2/16/2017.
 */
public class GetBooksRequest {
    private String ownerId;
    private Boolean wishlist;

    public GetBooksRequest() {
    }

    public GetBooksRequest(String ownerId, Boolean wishlist) {
        this.ownerId = ownerId;
        this.wishlist = wishlist;
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

        GetBooksRequest that = (GetBooksRequest) o;

        return new EqualsBuilder()
                .append(ownerId, that.ownerId)
                .append(wishlist, that.wishlist)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(ownerId)
                .append(wishlist)
                .toHashCode();
    }
}
