package casestudy.formatter;

import casestudy.entity.employee.Division;
import casestudy.service.employee.impl.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class DivisionFormatter implements Formatter<Division> {

    private IDivisionService iDivisionService;

    @Autowired
    public DivisionFormatter(IDivisionService iDivisionService) {
        this.iDivisionService = iDivisionService;
    }

    @Override
    public Division parse(String text, Locale locale) throws ParseException {
        Optional<Division> provinceOptional = iDivisionService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Division object, Locale locale) {
        return "[" + object.getDivisionId() + ", " +object.getDivisionName() + "]";
    }
}
