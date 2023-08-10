package de.lptrk.ecommerce.backend.product;


import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import de.lptrk.ecommerce.backend.user.UserEty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
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

    @PostMapping("products")
    public ResponseEntity<ProductEty> createProduct(@RequestBody ProductEty product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<ProductEty> updateUser(@PathVariable Integer id, @RequestBody ProductEty product) throws EntityNotFoundException {
        return new ResponseEntity<>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("products/{id}")
    public void deleteUser(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }


}
