package ru.innopolis.innoshop.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vyacheslav on 23.04.2017.
 */
@Controller
@RequestMapping("/order")
public class OrderPageController {
    @RequestMapping("")
    public String index() {
        return "order";
    }

    @RequestMapping("/confirmation")
    public String confirmation(final HttpServletRequest servletRequest, final Model model) {

        final String name = (String)servletRequest.getAttribute("Name");
        final String address = (String)servletRequest.getAttribute("Address");
        final String delivery = (String)servletRequest.getAttribute("optionsRadios");

        model.addAttribute("name",name);
        model.addAttribute("address",address);
        model.addAttribute("delivery",delivery);

        return "confirmation";
    }

}
