package com.my.ecommerce.shoppingcart.rest.mappers;

import com.my.ecommerce.shoppingcart.repositories.models.Product;
import com.my.ecommerce.shoppingcart.repositories.models.ShoppingCart;
import com.my.ecommerce.shoppingcart.rest.models.ShoppingCartModel;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartMapper {
    public static ShoppingCartModel map(ShoppingCart shoppingCart, List<Product> products) {
        return ShoppingCartModel.builder()
                .id(shoppingCart.getId())
                .clientId(shoppingCart.getClientId())
                .items(products.stream()
                        .map(ProductModelMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
