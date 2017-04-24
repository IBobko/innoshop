package ru.innopolis.innoshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.innoshop.cart.AddToCartEvent;

import javax.servlet.http.HttpSession;

/**
 * Created by Vyacheslav on 23.04.2017.
 */
@Controller
@RequestMapping("/product")
public class ProductPageController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @RequestMapping("/{id}")
    public String product(@PathVariable final Integer id) {
        return "product_" + id;
    }


    @RequestMapping("/add")
    public String add(@RequestParam Integer product_id, HttpSession session) {
        AddToCartEvent event = new AddToCartEvent(this);
        event.setSession(session);
        event.setProductID(product_id);
        publisher.publishEvent(event);
        return "redirect:/cart/";
    }
}
