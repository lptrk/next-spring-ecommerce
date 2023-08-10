package de.lptrk.ecommerce.backend.product;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ProductEty updateProduct(ProductEty p, Integer id) throws EntityNotFoundException {
        var getProduct = this.getProductById(id);
        getProduct.setName(p.getName());
        getProduct.setPrice(p.getPrice());
        getProduct.setDescription(p.getDescription());
        getProduct.setImageUrl(p.getImageUrl());
        return getProduct;
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

}
