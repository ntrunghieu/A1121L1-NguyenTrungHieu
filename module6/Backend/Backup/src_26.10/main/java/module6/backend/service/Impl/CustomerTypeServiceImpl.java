package module6.backend.service.Impl;

import module6.backend.entity.customer.CustomerType;
import module6.backend.repository.ICustomerTypeRepository;
import module6.backend.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAllCustomerType();
    }

}
