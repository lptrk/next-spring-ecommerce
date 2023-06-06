package de.lptrk.ecommerce.backend.category;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public ResponseEntity<List<CategoryEty>> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @GetMapping("categories/{id}")
    public Optional<CategoryEty> getCategoryById(@PathVariable("id") Integer id) {
        return (categoryService.getCategoryById(id));
    }

    record newCategoryRequest(
            String name,
            String description,
            Date createdAt,
            Date updatedAt
    ) {
    }

    @PostMapping("categories")
    public ResponseEntity<CategoryEty> createCategory(@RequestBody CategoryEty category) {
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }
}

