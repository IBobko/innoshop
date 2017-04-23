package ru.innopolis.innoshop.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vyacheslav on 23.04.2017.
 */
@Controller
@RequestMapping("")
public class ProductPageController {

    @RequestMapping("/product_{d}.html")
    public String product() {
        return "product_1";
    }
}
