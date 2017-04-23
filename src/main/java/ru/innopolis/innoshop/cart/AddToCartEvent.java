package ru.innopolis.innoshop.cart;

import org.springframework.context.ApplicationEvent;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class AddToCartEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public AddToCartEvent(Object source) {
        super(source);
    }
}
