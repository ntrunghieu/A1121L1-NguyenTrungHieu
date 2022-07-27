package service.category;

import entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    Optional<Category> findById(Long id);
//    Category findById(Long id);
    void save(Category category);
    void deleteById(Long id);
}
