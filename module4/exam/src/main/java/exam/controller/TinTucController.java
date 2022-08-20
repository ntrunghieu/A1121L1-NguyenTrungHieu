package exam.controller;
import exam.entity.DanhMuc;
import exam.entity.TinTuc;
import exam.service.danhmuc.impl.IDanhMucService;
import exam.service.tintuc.impl.ITinTucService;
import exam.validate.TinTucValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tintuc")
public class TinTucController {

    @Autowired
    private ITinTucService tinTucService;

    @Autowired
    private IDanhMucService danhMucService;

    @ModelAttribute("danhMucs")
    public Iterable<DanhMuc> danhMucs() {
        return danhMucService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("tintuc/create");
//        Iterable<Province> provinces = provinceService.findAll();
        TinTuc tinTuc= new TinTuc();
//        customer.setProvince(new Province());
//        modelAndView.addObject("provinces", provinces);

        modelAndView.addObject("tinTuc", tinTuc);
        return modelAndView;
    }

    @GetMapping("/timkiem/{id}")
    public ModelAndView timkiem(@PathVariable("id") Optional<Long> id, @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("tintuc/list");
        Page<TinTuc> tinTucs = null;
        if (id.isPresent()){
            tinTucs = tinTucService.timKiemTheoTenDanhMuc(id.get(),pageable);
        }else {
            tinTucs =tinTucService.findAll(pageable);
        }
//        Iterable<DanhMuc> danhMucs = danhMucService.findAll();
        modelAndView.addObject("tinTucs", tinTucs);
        return modelAndView;

    }
    @GetMapping("/search")
    public String search(@PageableDefault(value = 3) Pageable pageable, @RequestParam("timkiemtieude") Optional<String> name,
                         Model model ){

        Page<TinTuc> tinTucs;
        if (name.isPresent()){
            tinTucs= tinTucService.findAllByTieuDeContaining(name.get(), pageable);
        }else {
            tinTucs =tinTucService.findAll(pageable);
        }
        model.addAttribute("tinTucs",tinTucs);

        return "tintuc/list";

    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("tinTuc") TinTuc tinTuc, BindingResult bindingResult) {
        TinTucValidate validate = new TinTucValidate();
        validate.validate(tinTuc, bindingResult);
        ModelAndView modelAndView = new ModelAndView("tintuc/create");
        if (!bindingResult.hasErrors()) {
            tinTucService.save(tinTuc);
            modelAndView.addObject("tintuc", new TinTuc());
            modelAndView.addObject("message", "Tao tin tuc thanh cong!!");
        }
        return modelAndView;


    }

    @GetMapping("")
    public ModelAndView listCustomers( @RequestParam("tieuDe") Optional<String> tieuDe,
                                       @RequestParam("noiDung") Optional<String> noiDung,
                                       @RequestParam("danhMuc") Optional<String> danhMuc,
//                                       @RequestParam("search") Optional<String> search,
                                       @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("tintuc/list");
        Iterable<DanhMuc> danhMucs1 = danhMucService.findAll();
        Page<TinTuc> tinTucs;
//        if (search.isPresent()) {
//            tinTucs = (Page<TinTuc>) tinTucService.findAllByTieuDeContaining(search.get(), pageable);
//        } else {
//            tinTucs = tinTucService.findAll(pageable);
//        }

        if (tieuDe.isPresent() || noiDung.isPresent() || danhMuc.isPresent()){
            tinTucs = tinTucService.search(tieuDe.get(),noiDung.get(),danhMuc.get(),pageable);
        }else {
            tinTucs = tinTucService.findAll(pageable);
        }
//        search1=null;
//        if (search1==null){
//            search1="";
//        }
//        if (search1.equals("")){
//            tinTucs = tinTucService.findAll(pageable);
//        }else {
//            tinTucs = (Page<TinTuc>) tinTucService.findAllByTieuDeContaining(search1,pageable);
//        }

        modelAndView.addObject("tinTucs", tinTucs);
        modelAndView.addObject("danhMucs1", danhMucs1);
        return modelAndView;
    }




    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") TinTuc tinTuc, Model model) {
        Iterable<DanhMuc> danhMucs = danhMucService.findAll();
        model.addAttribute("danhMucs", danhMucs);
        model.addAttribute("tinTuc", tinTuc);
        return "tintuc/edit";

    }

    @GetMapping("/xoa")
    public String update(@RequestParam("idMove") Long id) {
       tinTucService.remove(id);
        return "redirect:/tintuc";

    }

}
