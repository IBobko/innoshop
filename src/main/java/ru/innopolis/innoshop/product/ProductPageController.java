package ru.innopolis.innoshop.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vyacheslav on 23.04.2017.
 */
@Controller
@RequestMapping("/product")
public class ProductPageController {
    @RequestMapping("/{id}")
    public String product(@PathVariable final Integer id) {
        return "product_" + id;
    }
}
