package codegym.controller;

import codegym.entity.Music;
import codegym.entity.MusicForm;
import javazoom.jl.decoder.JavaLayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import codegym.service.MusicService;
import codegym.service.impl.MusicServiceImpl;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javazoom.jl.player.Player;
@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private final MusicService getMusicService = new MusicServiceImpl();

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public String index(Model model) {

        List<Music> musicList = getMusicService.list();
        model.addAttribute("musicList", musicList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

//    @PostMapping("/play")
//    public String play(@ModelAttribute("music") MusicForm musicForm,Model model){
//        MultipartFile multipartFile = musicForm.getLink();
//        String link = multipartFile.getOriginalFilename();
//        try {
//            FileInputStream fis = new FileInputStream(fileUpload+link);
//            Player play = new Player(fis);
//            play.play();
//
//
////            FileCopyUtils.copy(musicForm.getLink().getBytes(), new File(fileUpload + link));
//        } catch (IOException | JavaLayerException e) {
//            e.printStackTrace();
//        }
//
//        List<Music> list = getMusicService.list();
//        model.addAttribute("musicList", list);
//        return "redirect:/music";
//    }

    @PostMapping("/save")
    public String save(@ModelAttribute("music") MusicForm musicForm, Model model) {

//
        MultipartFile multipartFile = musicForm.getLink();
        String link = multipartFile.getOriginalFilename();
        try {

            FileCopyUtils.copy(musicForm.getLink().getBytes(), new File(fileUpload + link));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        product1.setImage(fileName);
//        productService.save(product1);
//        return new RedirectView("");
        Music music= new Music(musicForm.getId(),musicForm.getName(),musicForm.getArtist(),
                musicForm.getType(),link);
        getMusicService.save(music);
        List<Music> list = getMusicService.list();
        model.addAttribute("musicList", list);
        return "redirect:/music";
    }


    @GetMapping("/{id}/update")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", getMusicService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("music") Music music) {
        getMusicService.update(music);

//        redirectAttributes.addFlashAttribute("mess","Edit song successfully");
        return "redirect:/music";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("music", getMusicService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Music customer, RedirectAttributes redirect) {
        getMusicService.remove(customer.getId());
//        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/music";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("music", getMusicService.findById(id));
        return "view";
    }
}
