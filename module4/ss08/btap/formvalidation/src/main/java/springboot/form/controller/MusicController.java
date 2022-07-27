package springboot.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.form.entity.Song;
import springboot.form.validate.SongValidator;

import javax.validation.Valid;

@Controller
public class MusicController {
    @GetMapping("/")
    public ModelAndView getForm() {
        return new ModelAndView("music/index","song",new Song());
    }

    @PostMapping("/")
    public ModelAndView save(@Valid @ModelAttribute Song song, BindingResult bindingResult) {
        new SongValidator().validate(song,bindingResult);
        if(bindingResult.hasErrors()) {
            return new ModelAndView("music/index","song",song);
        }else {
            return new ModelAndView("music/result");
        }
    }
}
