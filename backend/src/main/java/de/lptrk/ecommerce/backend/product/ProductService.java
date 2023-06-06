package de.lptrk.ecommerce.backend.product;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
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

    public ProductEty getProductById(Integer id) throws EntityNotFoundException {
        var product = productRepository.findById(id);

        if (product.isEmpty()) throw new EntityNotFoundException();

        return product.get();
    }

    public ProductEty saveProduct(ProductEty p) {
        return productRepository.save(p);
    }

}
