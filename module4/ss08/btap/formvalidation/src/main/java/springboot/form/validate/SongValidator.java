package springboot.form.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import springboot.form.entity.Song;

@Component
public class SongValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        if(!song.getName().matches("[a-z A-Z]*")) {
            errors.rejectValue("name","song.symbol","Invalid input");
        }
        if(!song.getAuthor().matches("[a-z A-Z]*")) {
            errors.rejectValue("author","song.symbol","Invalid input");
        }
        if(!song.getCategory().matches("[a-z A-Z \\,]*")) {
            errors.rejectValue("category","song.symbol","Invalid input");
        }
    }
}
