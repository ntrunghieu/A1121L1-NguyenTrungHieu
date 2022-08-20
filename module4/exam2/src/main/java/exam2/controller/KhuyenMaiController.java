package exam2.controller;

import exam2.entity.KhuyenMai;
import exam2.service.IKhuyenMaiService;
import exam2.validate.KhuyenMaiValidate;
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
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/khuyenmai")
public class KhuyenMaiController {
    @Autowired
    private IKhuyenMaiService iKhuyenMaiService;


    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
//        Iterable<Province> provinces = provinceService.findAll();
        KhuyenMai khuyenMai = new KhuyenMai();
//        customer.setProvince(new Province());
//        modelAndView.addObject("provinces", provinces);

        modelAndView.addObject("khuyenMai", khuyenMai);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("khuyenMai") KhuyenMai khuyenMai, BindingResult bindingResult) {
        KhuyenMaiValidate  validate = new KhuyenMaiValidate();
        validate.validate(khuyenMai, bindingResult);
        ModelAndView modelAndView = new ModelAndView("create");

        if (!bindingResult.hasErrors()) {
            iKhuyenMaiService.save(khuyenMai);
            modelAndView.addObject("khuyenMai", new KhuyenMai());
            modelAndView.addObject("message", "Tao thanh cong!!");
        }
        return modelAndView;


    }

    @GetMapping("")
    public ModelAndView list(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");

        Page<KhuyenMai> khuyenMais =iKhuyenMaiService.findAll(pageable);


//        if (search.isPresent()) {
//            tinTucs = (Page<TinTuc>) tinTucService.findAllByTieuDeContaining(search.get(), pageable);
//        } else {
//            tinTucs = tinTucService.findAll(pageable);
//        }

//        if (tieuDe.isPresent() || noiDung.isPresent() || danhMuc.isPresent()){
//            tinTucs = tinTucService.search(tieuDe.get(),noiDung.get(),danhMuc.get(),pageable);
//        }else {
//            tinTucs = tinTucService.findAll(pageable);
//        }
//        search1=null;
//        if (search1==null){
//            search1="";
//        }
//        if (search1.equals("")){
//            tinTucs = tinTucService.findAll(pageable);
//        }else {
//            tinTucs = (Page<TinTuc>) tinTucService.findAllByTieuDeContaining(search1,pageable);
//        }

        modelAndView.addObject("khuyenMais", khuyenMais);
        return modelAndView;
    }
    @GetMapping("/timkiem")
    public String search(@PageableDefault(value = 3) Pageable pageable,
                         @RequestParam("mucGiam") Optional<String> mucGiam,
                         @RequestParam("batDau") Optional<Date> batDau,
                         @RequestParam("ketThuc") Optional<Date> ketThuc,
                         Model model ){

        Page<KhuyenMai> khuyenMais;
        if (mucGiam.isPresent()){
            khuyenMais=iKhuyenMaiService.findAllByMucGiamGiaContaining(mucGiam.get(),pageable);
            //khuyenMais= iKhuyenMaiService.findAllByMucGiamGiaAndBatDauAndKetThucContaining(mucGiam.get(),batDau.get(),ketThuc.get(), pageable);
        }else {
            khuyenMais =iKhuyenMaiService.findAll(pageable);
        }
        model.addAttribute("khuyenMais",khuyenMais);

        return "list";

    }


    @GetMapping("/xoa")
    public String update(@RequestParam("idMove") Long id) {
        iKhuyenMaiService.remove(id);
        return "redirect:/khuyenmai";

    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") KhuyenMai khuyenMai, Model model) {


        model.addAttribute("message", "Sua thanh cong!!");
        model.addAttribute("khuyenMai", khuyenMai);
        return "update";

    }



//    @GetMapping("/timkiem/{id}")
//    public ModelAndView timkiem(@PathVariable("id") Optional<Long> id, @PageableDefault(value = 3) Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("tintuc/list");
//        Page<TinTuc> tinTucs = null;
//        if (id.isPresent()){
//            tinTucs = tinTucService.timKiemTheoTenDanhMuc(id.get(),pageable);
//        }else {
//            tinTucs =tinTucService.findAll(pageable);
//        }
////        Iterable<DanhMuc> danhMucs = danhMucService.findAll();
//        modelAndView.addObject("tinTucs", tinTucs);
//        return modelAndView;
//
//    }

}
