package casestudy.service.customer;

import casestudy.entity.customer.CustomerType;
import casestudy.entity.employee.Position;
import casestudy.repository.customer.ICustomerRepository;
import casestudy.repository.customer.ICustomerTypeRepository;
import casestudy.service.customer.impl.ICustomerServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerServiceType implements ICustomerServiceType {


    private ICustomerTypeRepository iCustomerTypeRepository;

    @Autowired
    public CustomerServiceType(ICustomerTypeRepository iCustomerTypeRepository) {
        this.iCustomerTypeRepository = iCustomerTypeRepository;
    }




    @Override
    public Iterable<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(Long id) {
        return iCustomerTypeRepository.findById(id);
    }
}
