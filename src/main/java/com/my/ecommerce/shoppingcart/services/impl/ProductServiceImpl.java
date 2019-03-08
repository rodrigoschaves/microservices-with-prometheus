package com.my.ecommerce.shoppingcart.services.impl;

import com.my.ecommerce.shoppingcart.repositories.ProductServiceRepository;
import com.my.ecommerce.shoppingcart.repositories.models.Product;
import com.my.ecommerce.shoppingcart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductServiceRepository repository;

    @Override
    public List<Product> findByIds(List<UUID> productsIds) {
        return repository.findByIds(productsIds);
    }
}
