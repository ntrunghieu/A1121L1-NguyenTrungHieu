package controller;

import model.Book;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin", produces = "application/x-www-form-urlencoded;charset=UTF-8")
public class AdminController {
    @Autowired
    private BookService bookService;

    @ModelAttribute("category")
    public List<Category> allCategories() {
        return bookService.selectAllCategory();
    }


    @GetMapping("/book-create")
    public ModelAndView createBook(){
        ModelAndView modelAndView = new ModelAndView("admin/create");
        Book book = new Book();
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @PostMapping("/book-save")
    public String saveBook( @ModelAttribute("book") Book book){
        System.out.println(book.getBookName());
        bookService.saveBook(book);
        return "redirect:/admin/book-create";
    }
    @PostMapping("/book-update")
    public String updateBook( @ModelAttribute("book") Book book){
        System.out.println(book.getBookName());
        bookService.updateBook(book);
        return "redirect:/admin/book-edit/" + book.getBookId();
    }

    @GetMapping("/book-delete/{id}")
    public String deleteBook( @PathVariable("id") Long id){
        System.out.println(id);
        bookService.deleteBook(id);
        return "redirect:/home";
    }

    @GetMapping("/book-edit/{bookId}")
    public String editBook(ModelMap modelMap ,@ModelAttribute("book") Book book, @PathVariable("bookId") Long id){
        System.out.println(book.getBookName());
        Book  book1 = bookService.findBookById(id);
        modelMap.addAttribute("book", book1);
        return "admin/edit";
    }



}
