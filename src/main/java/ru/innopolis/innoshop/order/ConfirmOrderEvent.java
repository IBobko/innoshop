package ru.innopolis.innoshop.order;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpSession;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class ConfirmOrderEvent extends ApplicationEvent {

    private HttpSession session;
    private String name;
    private String address;
    private String delivery;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ConfirmOrderEvent(Object source) {
        super(source);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }


}
