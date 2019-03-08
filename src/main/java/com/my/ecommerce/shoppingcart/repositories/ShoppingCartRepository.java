package com.my.ecommerce.shoppingcart.repositories;

import com.my.ecommerce.shoppingcart.repositories.models.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, UUID> {
}
