package pro.mynook.app.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jaxichael on 2/17/2017.
 */
public class RequestError {
    public final String url;
    public final String error;

    public RequestError(String title, Exception ex) {
        this.url = title;
        this.error = ex.getLocalizedMessage();
    }
}
