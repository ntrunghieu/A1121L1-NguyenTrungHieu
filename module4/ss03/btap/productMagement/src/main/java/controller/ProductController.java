package controller;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;
import service.impl.ProductServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductService productService1 = new ProductServiceImpl();

    @GetMapping("")
    public String index(Model model) {

        List<Product> productList = productService1.findAll();
        model.addAttribute("productList", productList);
        return "index";
    }

    @PostMapping("/search")
    public String searchByName(@RequestParam("name")String name, Model model){


       String input="";
       if (name == null ){
           name="";
       }
       if (name==input){
           List<Product> productList = productService1.findAll();
           model.addAttribute("name", name);
           model.addAttribute("productList", productList);
       }else {
           Product productList = productService1.findByName(name);
           model.addAttribute("name", name);
           model.addAttribute("productList", productList);
       }

        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService1.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService1.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Product product) {
        productService1.update(product.getId(), product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService1.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService1.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService1.findById(id));
        return "/view";
    }
}
