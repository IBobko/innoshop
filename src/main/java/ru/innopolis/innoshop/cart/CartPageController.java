package ru.innopolis.innoshop.cart;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/cart")
public class CartPageController {

    @RequestMapping("")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestParam Integer product_id, HttpSession session) {
        CartModel cartModel = (CartModel)session.getAttribute("cart");
        if (cartModel == null) {
            cartModel = new CartModel();
            session.setAttribute("cart",cartModel);
        }
        cartModel.products.add(product_id);
        return "OK";
    }
}
