package com.my.ecommerce.shoppingcart.rest.models;

import lombok.Builder;
import lombok.Data;

import java.util.Currency;
import java.util.UUID;

@Data
@Builder
public class ProductModel {

    private UUID Id;

    private double price;

    private String name;

    private String description;

    private Currency currency;
}
