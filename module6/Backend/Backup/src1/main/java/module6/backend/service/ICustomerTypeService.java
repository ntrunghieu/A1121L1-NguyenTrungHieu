package module6.backend.service;

import module6.backend.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAllCustomerType();

}
