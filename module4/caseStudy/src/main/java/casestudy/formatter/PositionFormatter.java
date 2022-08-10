package casestudy.formatter;

import casestudy.entity.employee.EducationDegree;
import casestudy.entity.employee.Position;
import casestudy.service.employee.impl.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class PositionFormatter implements Formatter<Position> {
    private IPositionService iPositionService;
    @Autowired
    public PositionFormatter(IPositionService iPositionService) {
        this.iPositionService = iPositionService;
    }




    @Override
    public Position parse(String text, Locale locale) throws ParseException {
        Optional<Position> provinceOptional = iPositionService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Position object, Locale locale) {
        return "[" + object.getPositionId() + ", " +object.getPositionName() + "]";
    }
}
