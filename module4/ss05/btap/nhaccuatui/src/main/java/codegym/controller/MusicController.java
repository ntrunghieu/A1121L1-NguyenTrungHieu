package codegym.controller;

import codegym.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import codegym.service.MusicService;
import codegym.service.impl.MusicServiceImpl;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Qualifier("musicService")
    @Autowired
    private final MusicService musicService = new MusicServiceImpl();

    @GetMapping("")
    public String index(Model model) {

        List<Music> musicList = musicService.list();
        model.addAttribute("musicList", musicList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("music") Music music) {
        Music music1 = new Music(music.getId(),music.getName(),music.getArtist(),music.getType(),music.getType());
//        music.setId((int) (Math.random() * 10000));
        if (musicService.list() == null){
            musicService.save(music1);
        }else {
            musicService.update(music1);
        }

        return "redirect:/save";
    }
    @GetMapping("/{id}/update")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("music") Music music) {
        musicService.update(music);

//        redirectAttributes.addFlashAttribute("mess","Edit song successfully");
        return "redirect:/music";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Music customer, RedirectAttributes redirect) {
        musicService.remove(customer.getId());
//        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/music";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "view";
    }
}
