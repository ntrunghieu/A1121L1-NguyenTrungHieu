package casestudy.service.service;

import casestudy.entity.service.RentType;
import casestudy.repository.service.IRentTypeRepository;
import casestudy.service.service.impl.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RentTypeService implements IRentTypeService {
    private IRentTypeRepository iRentTypeRepository;

    @Autowired
    public RentTypeService(IRentTypeRepository iRentTypeRepository) {
        this.iRentTypeRepository = iRentTypeRepository;
    }

    @Override
    public List<RentType> findAll1() {
        return null;
    }

    @Override
    public Iterable<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public Optional<RentType> findById(Long id) {
        return iRentTypeRepository.findById(id);
    }
}
