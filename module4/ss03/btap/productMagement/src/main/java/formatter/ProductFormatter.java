package formatter;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.IProductService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProductFormatter implements Formatter<Product> {
    private IProductService productService;

    @Autowired
    public ProductFormatter(IProductService productService) {
        this.productService = productService;
    }


    @Override
    public Product parse(String text, Locale locale) throws ParseException {
        Optional<Product> provinceOptional = productService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Product object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
