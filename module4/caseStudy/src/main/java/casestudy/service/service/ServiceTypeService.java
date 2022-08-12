package casestudy.service.service;

import casestudy.entity.service.ServiceType;
import casestudy.repository.service.IServiceTypeRepository;
import casestudy.service.service.impl.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeService implements IServiceTypeService {
    private IServiceTypeRepository iServiceTypeRepository;

    @Autowired
    public ServiceTypeService(IServiceTypeRepository iServiceTypeRepository) {
        this.iServiceTypeRepository = iServiceTypeRepository;
    }

    @Override
    public List<ServiceType> findAll1() {
        return null;
    }

    @Override
    public Iterable<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Long id) {
        return iServiceTypeRepository.findById(id);
    }
}
