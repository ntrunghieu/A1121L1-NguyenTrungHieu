package controller;

import DAO.BookDAO;
import model.Book;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.BookRepository;
import service.BookService;
import service.IBookService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired private BookService bookService;

//    @ModelAttribute("category")
//    public Iterable<Category> allCategory() {
//        return bookDAO.ge();
//    }
//    @GetMapping("")
//    public ModelAndView home(){
//        ModelAndView mv = new ModelAndView("home");
////        mv.addObject("listBook", bookRepository.getList());
//        return mv;
//    }

    @GetMapping("")
    public ModelAndView home(){
        List<Book> listBook = bookService.selectAllBook();
        for (Book book: listBook) {
            System.out.println(book.getBookName());
        }
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("listBook", listBook);
        return mv;
    }


}
