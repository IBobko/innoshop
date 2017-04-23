package ru.innopolis.innoshop.cart;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/cart")
public class CartPageController {

    @Autowired
    private ApplicationEventPublisher publisher;


    @RequestMapping("")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/add")
    public String add(@RequestParam Integer product_id, HttpSession session) {
        AddToCartEvent event = new AddToCartEvent(this);
        event.setSession(session);
        event.setProductID(product_id);
        publisher.publishEvent(event);
        return "redirect:/product/" + product_id;
    }

    @EventListener
    public void listener(AddToCartEvent event) {
        CartModel cartModel = (CartModel)event.getSession().getAttribute("cart");
        if (cartModel == null) {
            cartModel = new CartModel();
            event.getSession().setAttribute("cart",cartModel);
        }
        cartModel.products.add(event.getProductID());
    }
}
