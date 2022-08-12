package casestudy.service.service.impl;

import casestudy.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    void save(Service service);

    Optional<Service> findById(Long id);

    Service findById1(Long id);

    void delete(Long id);

    Iterable<Service> findAll();

    Page<Service> findAll(Pageable pageable);
    List<Service> findAllAPI(Pageable pageable);
//    Page<Service> findAllByServiceNameContaining(String name, Pageable pageable);
    List<Service> findAllByServiceNameContaining(String name, Pageable pageable);
}
