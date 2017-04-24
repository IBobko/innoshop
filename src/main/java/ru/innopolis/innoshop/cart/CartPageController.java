package ru.innopolis.innoshop.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cart")
public class CartPageController {
    @RequestMapping("")
    public String cart() {
        return "cart";
    }

    @EventListener
    public void listener(AddToCartEvent event) {
        CartModel cartModel = (CartModel) event.getSession().getAttribute("cart");
        if (cartModel == null) {
            cartModel = new CartModel();
            event.getSession().setAttribute("cart", cartModel);
        }
        cartModel.products.add(event.getProductID());
    }
}
