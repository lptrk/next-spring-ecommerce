package de.lptrk.ecommerce.backend.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEty> getProducts() {
        return productRepository.findAll();
    }

    //TODO: Product not found Exception

    public Optional<ProductEty> getProductById(Integer id) {
        try {
            return productRepository.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public ProductEty saveProduct(ProductEty p) {
        return productRepository.save(p);
    }
}
