package com.my.ecommerce.shoppingcart.rest.mappers;

import com.my.ecommerce.shoppingcart.repositories.models.Product;
import com.my.ecommerce.shoppingcart.rest.models.ProductModel;

public class ProductModelMapper {

    public static ProductModel map(Product product) {
        return ProductModel.builder()
                .Id(product.getId())
                .name(product.getName())
                .currency(product.getCurrency())
                .description(product.getDescription())
                .build();
    }
}
