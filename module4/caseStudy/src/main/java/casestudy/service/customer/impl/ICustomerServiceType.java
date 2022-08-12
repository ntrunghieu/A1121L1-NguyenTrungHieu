package casestudy.service.customer.impl;

import casestudy.entity.customer.Customer;
import casestudy.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerServiceType {
    Iterable<CustomerType> findAll();
    Optional<CustomerType> findById(Long id);

    Page<CustomerType> findAllByCustomerTypeNameContaining(String name, Pageable pageable);
}
