package service.category;

import entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.ICategoryRepository;

import java.util.Optional;


@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository categoryRepo;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepo.findById(id);
    }

//    @Override
//    public Category findById(Long id) {
//        return null;
//    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void deleteById(Long id) {

    }


}
