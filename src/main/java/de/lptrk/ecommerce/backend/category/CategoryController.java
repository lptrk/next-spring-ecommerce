package de.lptrk.ecommerce.backend.category;


import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
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
    public ResponseEntity<CategoryEty> getCategoryById(@PathVariable("id") Integer id) throws EntityNotFoundException {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
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

    @PutMapping("categories/{id}")
    public ResponseEntity<CategoryEty> updateCategory(@PathVariable Integer id, @RequestBody CategoryEty categoryEty) throws EntityNotFoundException {
        return new ResponseEntity<>(
                categoryService.updateCategory(
                        categoryEty, id)
                , HttpStatus.OK);
    }

    @DeleteMapping("categories/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}

