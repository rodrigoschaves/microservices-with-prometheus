package com.my.ecommerce.shoppingcart.services.impl;

import com.my.ecommerce.shoppingcart.repositories.ShoppingCartRepository;
import com.my.ecommerce.shoppingcart.repositories.models.ShoppingCart;
import com.my.ecommerce.shoppingcart.rest.models.ProductModel;
import com.my.ecommerce.shoppingcart.rest.models.ShoppingCartModel;
import com.my.ecommerce.shoppingcart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository repository;

    @Override
    public List<ShoppingCart> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ShoppingCart> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public ShoppingCart insert(ShoppingCartModel products) {
        ShoppingCart toPersist = new ShoppingCart();
        toPersist.setProductsIds(products.getItems()
                .stream()
                .map(ProductModel::getId)
                .collect(Collectors.toList()));

        return repository.insert(toPersist);
    }

    @Override
    public Optional<ShoppingCart> update(UUID id, ShoppingCartModel model) {
        return this.repository.findById(id)
                .map(s -> {
                    s.setProductsIds(
                            model.getItems()
                                    .stream()
                                    .map(ProductModel::getId)
                                    .collect(Collectors.toList()));
                    return this.repository.save(s);
                });
    }

    @Override
    public Optional<ShoppingCart> delete(UUID id) {
        return this.repository.findById(id)
                .map(s -> {
                    this.repository.delete(s);
                    return s;
                });
    }
}

