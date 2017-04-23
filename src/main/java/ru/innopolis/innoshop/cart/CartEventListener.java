package ru.innopolis.innoshop.cart;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */

public class CartEventListener implements ApplicationListener<AddToCartEvent> {

    @Override
    public void onApplicationEvent(AddToCartEvent event) {
        System.out.println("System yandex.ru");
    }
}
