package casestudy.formatter;

import casestudy.entity.employee.Division;
import casestudy.entity.employee.EducationDegree;
import casestudy.service.employee.impl.IDivisionService;
import casestudy.service.employee.impl.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;


@Component
public class EducationFormatter implements Formatter<EducationDegree> {

    private IEducationService iEducationService;

    @Autowired
    public EducationFormatter(IEducationService iEducationService) {
        this.iEducationService = iEducationService;
    }

    @Override
    public EducationDegree parse(String text, Locale locale) throws ParseException {
        Optional<EducationDegree> provinceOptional = iEducationService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(EducationDegree object, Locale locale) {
        return "[" + object.getEducationDegreeId() + ", " +object.getEducationName() + "]";
    }





}