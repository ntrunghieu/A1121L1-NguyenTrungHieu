package casestudy.formatter;

import casestudy.entity.customer.CustomerType;
import casestudy.entity.employee.EducationDegree;
import casestudy.service.customer.impl.ICustomerService;
import casestudy.service.customer.impl.ICustomerServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class CustomerTypeFormatter implements Formatter<CustomerType> {
    private ICustomerServiceType iCustomerServiceType;
    @Autowired
    public CustomerTypeFormatter(ICustomerServiceType iCustomerServiceType) {
        this.iCustomerServiceType = iCustomerServiceType;
    }








    @Override
    public CustomerType parse(String text, Locale locale) throws ParseException {
        Optional<CustomerType> provinceOptional = iCustomerServiceType.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(CustomerType object, Locale locale) {
        return "[" + object.getCustomerTypeId() + ", " +object.getCustomerTypeName() + "]";
    }
}
