package casestudy.service.customer.impl;

import casestudy.entity.customer.CustomerType;

import java.util.Optional;

public interface ICustomerServiceType {
    Iterable<CustomerType> findAll();
    Optional<CustomerType> findById(Long id);
}
