package pro.mynook.app.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Jaxichael on 2/17/2017.
 */
public class DeleteBookOwnerRequest {
    private String ownerId;
    private String bookId;

    public DeleteBookOwnerRequest() {
    }

    public DeleteBookOwnerRequest(String ownerId, String bookId) {
        this.ownerId = ownerId;
        this.bookId = bookId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        DeleteBookOwnerRequest that = (DeleteBookOwnerRequest) o;

        return new EqualsBuilder()
                .append(ownerId, that.ownerId)
                .append(bookId, that.bookId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(ownerId)
                .append(bookId)
                .toHashCode();
    }
}
