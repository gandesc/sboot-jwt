package ro.gandesc.jwt.service;

import ro.gandesc.jwt.domain.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductService {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(0);

    public ProductService() {
        addProduct(Product.builder().name("First Product").description("First Product Description").build());
        addProduct(Product.builder().name("Second Product").description("Second Product Description").build());
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public Product getProductById(long id) {
        return productMap.get(id);
    }

    public void addProduct(Product product) {
        if (productMap.values().stream().anyMatch(p -> p.getName().equals(product.getName()))) {
            throw new IllegalArgumentException(String.format("Product with name %s already exists", product.getName()));
        }

        product.setId(idCounter.incrementAndGet());
        productMap.put(product.getId(), product);
    }

    public void deleteProductById(long id) {
        if (!productMap.containsKey(id)) {
            throw new IllegalArgumentException(String.format("Product with id %d doesn't exist", id));
        }

        productMap.remove(id);
    }

}
