package ro.gandesc.jwt.web.controllers;

import lombok.RequiredArgsConstructor;
import ro.gandesc.jwt.services.ProductService;
import ro.gandesc.jwt.domain.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @PreAuthorize("hasAuthority('products.read')")
    public Collection<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('products.create')")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('products.delete')")
    public void removeProduct(@PathVariable long id) {
        productService.deleteProductById(id);
    }

}
