package ru.innopolis.innoshop.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.innoshop.cart.AddToCartEvent;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@RequestMapping("/")
@Controller
public class HomePageController {

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * Main page of our site.
     *
     * @return Text which provided users.
     */
    @RequestMapping("")
    public String index() {

        AddToCartEvent event = new AddToCartEvent(this);

        publisher.publishEvent(event);

        return "index";

    }

    @EventListener
    public void test(AddToCartEvent event) {
        System.out.println("WON'T WORK :-(");  // FIXME
    }
}
