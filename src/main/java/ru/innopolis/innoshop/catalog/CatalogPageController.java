package ru.innopolis.innoshop.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vyacheslav on 23.04.2017.
 */
@Controller
@RequestMapping("/products")
public class CatalogPageController {

    @RequestMapping("")
    public String products() {
        return "products";
    }
}
