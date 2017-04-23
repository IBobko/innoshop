package ru.innopolis.innoshop.cart;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpSession;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class AddToCartEvent extends ApplicationEvent {
    private HttpSession session;
    private Integer productID;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public AddToCartEvent(Object source) {
        super(source);
    }

    public void setSession(final HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getProductID() {
        return productID;
    }

}
