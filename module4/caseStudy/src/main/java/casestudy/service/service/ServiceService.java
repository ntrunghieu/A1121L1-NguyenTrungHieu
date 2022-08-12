package casestudy.service.service;

import casestudy.entity.service.Service;
import casestudy.repository.service.IServiceRepository;
import casestudy.service.service.impl.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ServiceService implements IServiceService {
    private IServiceRepository iServiceRepository;
    @Autowired
    public ServiceService(IServiceRepository iServiceRepository) {
        this.iServiceRepository = iServiceRepository;
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public Optional<Service> findById(Long id)
    {
        return iServiceRepository.findById(id);
    }

    @Override
    public Service findById1(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public Iterable<Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return iServiceRepository.findAll(pageable);
    }

    @Override
    public List<Service> findAllAPI(Pageable pageable) {
        return iServiceRepository.findAll();
    }

    @Override
    public List<Service> findAllByServiceNameContaining(String name, Pageable pageable) {
        return iServiceRepository.findAllByServiceNameContaining(name,pageable);
    }
}
