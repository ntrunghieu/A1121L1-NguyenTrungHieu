package formatter;

import entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import repository.ICategoryRepository;
import service.category.ICategoryService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class CategoryFormatter implements Formatter<Category> {
    private ICategoryService categoryService;


    @Autowired
    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> provinceOptional = categoryService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getCategoryId() + ", " +object.getName() + "]";
    }
}
