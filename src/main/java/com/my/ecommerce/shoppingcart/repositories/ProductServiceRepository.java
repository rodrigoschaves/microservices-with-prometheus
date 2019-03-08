package com.my.ecommerce.shoppingcart.repositories;

import com.my.ecommerce.shoppingcart.repositories.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductServiceRepository {
    public List<Product> findByIds(List<UUID> ids) {
        return new ArrayList<>();
    }
}
