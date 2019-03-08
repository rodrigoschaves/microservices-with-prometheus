package com.my.ecommerce.shoppingcart.rest;

import com.my.ecommerce.shoppingcart.repositories.models.ShoppingCart;
import com.my.ecommerce.shoppingcart.rest.models.ShoppingCartModel;
import com.my.ecommerce.shoppingcart.services.ProductService;
import com.my.ecommerce.shoppingcart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.my.ecommerce.shoppingcart.rest.mappers.ShoppingCartMapper.map;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService service;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ShoppingCartModel> getCarts() {
        return service.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartModel> getById(@RequestParam UUID id) {
        return service.findById(id)
                .map(p -> new ResponseEntity<>(this.toModel(p), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ShoppingCartModel> insert(@RequestBody ShoppingCartModel model) {
        return new ResponseEntity<>(toModel(this.service.insert(model)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCartModel> update(@RequestParam("id") UUID id, @RequestBody ShoppingCartModel model) {
        return this.service.update(id, model)
                .map(p -> new ResponseEntity<>(this.toModel(p), HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestParam("id") UUID id) {
        return this.service.delete(id)
                .map(t -> new ResponseEntity<Void>(HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    private ShoppingCartModel toModel(ShoppingCart s) {
        return map(s, productService.findByIds(s.getProductsIds()));
    }
}
