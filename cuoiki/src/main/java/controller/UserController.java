package controller;

import model.Book;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;

import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BookService bookService;
    @ModelAttribute("category")//lay ds = name
    public List<Category> allCategories() {
        return bookService.selectAllCategory();
    }
    @GetMapping("")
    public ModelAndView home(@RequestParam(value = "kw", required = false, defaultValue = "") String searchName){
//        List<Book> listBook = bookService.selectAllBook();
        List<Book> listBook = bookService.getBooks(searchName);
        for (Book book: listBook) {
            System.out.println(book.getBookName());
        }
        ModelAndView mv = new ModelAndView("user/homeuser");
        mv.addObject("listBook", listBook);
        return mv;
    }
}
