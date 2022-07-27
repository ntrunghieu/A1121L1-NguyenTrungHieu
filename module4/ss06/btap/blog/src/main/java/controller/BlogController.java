package controller;


import entity.Blog;
import entity.BlogForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.blog.IBlogService;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class BlogController {
    @Value("${file-upload}")
    private String fileUpload;



    @Autowired
    private IBlogService blogService;

//    @GetMapping("")
//    public String getHome(Model model){
//
//        Iterable<Blog> blogs= blogService.findAll();
//        model.addAttribute("blogs", blogs);
//        return "blog/home";
//    }
        @GetMapping("")
    public ModelAndView listCustomers(@PageableDefault(value = 3) Pageable pageable){
        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/home");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blogForm", new BlogForm());
        return modelAndView;
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("blog") BlogForm blogForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = blogForm.getImg();
        String img = multipartFile.getOriginalFilename();
        try {

            FileCopyUtils.copy(blogForm.getImg().getBytes(), new File(fileUpload + img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Blog blog = new Blog(img,blogForm.getTitle(),blogForm.getDescription(),blogForm.getContent());
        blogService.save(blog);

//        customerService.insertWithStoredProcedure(customer);
        redirectAttributes.addFlashAttribute("mess","Create new blog successfully!");
        return "redirect:/home/create";
    }

    @GetMapping("/{id}/update")
    public ModelAndView editForm(@PathVariable("id") Long id) {
        Optional<Blog> blog = blogService.findById(id);
//        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/edit","blog",blog);

        return modelAndView;
    }

//    @PostMapping("/update")
//    public String editCustomer(@ModelAttribute("blog") BlogForm blogForm, RedirectAttributes redirectAttributes) {
//        MultipartFile multipartFile = blogForm.getImg();
//        String img = multipartFile.getOriginalFilename();
//        try {
//
//            FileCopyUtils.copy(blogForm.getImg().getBytes(), new File(fileUpload + img));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Blog blog = new Blog(blogForm.getId(),img,blogForm.getTitle(),blogForm.getDescription(),blogForm.getContent());
//        blogService.update(blog);
//
////        customerService.insertWithStoredProcedure(customer);
//        redirectAttributes.addFlashAttribute("mess","Create new blog successfully!");
//        return "blog/home";
//    }

//    @GetMapping("/{id}/delete")
//    public ModelAndView deleteForm(@PathVariable("id") Long id){
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("customer/delete","customer",customer);
//
//        return modelAndView;
//    }
//
//    @GetMapping("/delete")
//    public String deleteCustomer(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
//        customerService.remove(id);
////        redirectAttributes.addFlashAttribute("mess","Delete customer successfully!");
//        return "redirect:/home";
//    }
}
