package ru.innopolis.innoshop.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vyacheslav on 23.04.2017.
 */
public class CartModel {
    public List<Integer> products = new ArrayList<>();

    public List<Integer> getProducts() {
        return products;
    }
}
