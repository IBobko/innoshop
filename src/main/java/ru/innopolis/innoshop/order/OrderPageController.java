package ru.innopolis.innoshop.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vyacheslav on 23.04.2017.
 */
@Controller
@RequestMapping("/order")
public class OrderPageController {
    @RequestMapping("")
    String index() {
        return "order";
    }

    @RequestMapping("/confirmation")
    String confirmation() {
        return "confirmation";
    }

}
