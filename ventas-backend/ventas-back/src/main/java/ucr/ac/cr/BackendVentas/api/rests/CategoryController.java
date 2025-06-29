package ucr.ac.cr.BackendVentas.api.rests;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.cr.BackendVentas.api.types.CategoryDTO;
import ucr.ac.cr.BackendVentas.jpa.entities.CategoryEntity;
import ucr.ac.cr.BackendVentas.jpa.repositories.CategoryRepository;

import java.util.List;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();

        List<CategoryDTO> dtos = categories.stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName()))
                .toList();

        return ResponseEntity.ok(dtos);
    }

}
