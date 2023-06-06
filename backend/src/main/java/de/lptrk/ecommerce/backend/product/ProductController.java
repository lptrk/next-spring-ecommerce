package de.lptrk.ecommerce.backend.product;


import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseEntity<List<ProductEty>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<ProductEty> getProductById(@PathVariable("id") Integer id) throws EntityNotFoundException {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    record newProductRequest(String name,
                             String description,
                             Double price,
                             Integer categoryId,
                             String imageUrl,
                             Date createdAt,
                             Date updatedAt) {
    }

    @PostMapping("products")
    public ResponseEntity<ProductEty> createProduct(@RequestBody ProductEty product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

}
