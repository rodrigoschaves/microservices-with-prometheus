package com.my.ecommerce.shoppingcart.repositories.models;

import lombok.Data;

import java.util.Currency;
import java.util.UUID;

@Data
public class Product {

    private UUID Id;

    private double price;

    private String name;

    private String description;

    private Currency currency;
}
