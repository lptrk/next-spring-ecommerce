package de.lptrk.ecommerce.backend.category;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
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

    public CategoryEty getCategoryById(Integer id) throws EntityNotFoundException {

        var category= categoryRepository.findById(id);
        if(category.isEmpty()) throw new EntityNotFoundException();
        return category.get();
    }

    public CategoryEty saveCategory(CategoryEty categoryEty) {
        return categoryRepository.save(categoryEty);
    }

    public CategoryEty updateCategory(CategoryEty c, Integer id) throws EntityNotFoundException {
        var getCategory = this.getCategoryById(id);
        getCategory.setName(c.getName());
        getCategory.setDescription(c.getDescription());
        getCategory.setUpdatedAt(c.getUpdatedAt());
        getCategory.setCreatedAt(c.getCreatedAt());
        return getCategory;
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
