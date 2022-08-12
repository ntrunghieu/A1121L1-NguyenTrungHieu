package casestudy.formatter;

import casestudy.entity.employee.Position;
import casestudy.entity.service.RentType;
import casestudy.service.service.impl.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class RentTypeFormatter implements Formatter<RentType> {
    private IRentTypeService iRentTypeService;

    @Autowired
    public RentTypeFormatter(IRentTypeService iRentTypeService) {
        this.iRentTypeService = iRentTypeService;
    }

    @Override
    public RentType parse(String text, Locale locale) throws ParseException {
        Optional<RentType> provinceOptional = iRentTypeService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(RentType object, Locale locale) {
        return "[" + object.getRentTypeId() + ", " +object.getRentTypeName() + "]";
    }
}
