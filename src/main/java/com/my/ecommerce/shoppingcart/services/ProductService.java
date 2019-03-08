package com.my.ecommerce.shoppingcart.services;

import com.my.ecommerce.shoppingcart.repositories.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> findByIds(List<UUID> productsIds);

}
