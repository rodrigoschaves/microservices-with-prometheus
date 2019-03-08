package com.my.ecommerce.shoppingcart.rest.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class ShoppingCartModel {

    private UUID id;

    private UUID clientId;

    private List<ProductModel> items;
}
