package pro.mynook.app.dto;

import pro.mynook.app.pojo.Book;

/**
 * Created by Jaxichael on 2/16/2017.
 */
public class OwnedBook extends Book {
    private String statusValue;
    private String wishlist;
    private Integer rating;

    public OwnedBook() {
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getWishlist() {
        return wishlist;
    }

    public void setWishlist(String wishlist) {
        this.wishlist = wishlist;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
