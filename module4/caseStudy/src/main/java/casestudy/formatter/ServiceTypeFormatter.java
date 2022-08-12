package casestudy.formatter;

import casestudy.entity.service.RentType;
import casestudy.entity.service.ServiceType;
import casestudy.service.service.impl.IServiceService;
import casestudy.service.service.impl.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class ServiceTypeFormatter implements Formatter<ServiceType> {
    private IServiceTypeService iServiceService;

    @Autowired
    public ServiceTypeFormatter(IServiceTypeService iServiceService) {
        this.iServiceService = iServiceService;
    }

    @Override
    public ServiceType parse(String text, Locale locale) throws ParseException {
        Optional<ServiceType> provinceOptional = iServiceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(ServiceType object, Locale locale) {
        return "[" + object.getServiceTypeId() + ", " +object.getServiceTypeName() + "]";
    }
}
