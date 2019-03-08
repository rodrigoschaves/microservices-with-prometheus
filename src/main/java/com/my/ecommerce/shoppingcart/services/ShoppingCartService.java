package com.my.ecommerce.shoppingcart.services;

import com.my.ecommerce.shoppingcart.repositories.models.ShoppingCart;
import com.my.ecommerce.shoppingcart.rest.models.ShoppingCartModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoppingCartService {

    List<ShoppingCart> findAll();

    Optional<ShoppingCart> findById(UUID id);

    ShoppingCart insert(ShoppingCartModel products);

    Optional<ShoppingCart> update(UUID id, ShoppingCartModel model);

    Optional<ShoppingCart> delete(UUID id);
}
