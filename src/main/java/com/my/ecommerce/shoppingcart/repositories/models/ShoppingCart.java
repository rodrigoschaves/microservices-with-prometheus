package com.my.ecommerce.shoppingcart.repositories.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "accounts")
public class ShoppingCart {

    private UUID id;

    private UUID clientId;

    private List<UUID> productsIds;
}
