package de.lptrk.ecommerce.backend.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEty> getCategories() {
        return categoryRepository.findAll();
    }

    public Optional<CategoryEty> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    public CategoryEty saveCategory(CategoryEty categoryEty) {
        return categoryRepository.save(categoryEty);
    }


}
