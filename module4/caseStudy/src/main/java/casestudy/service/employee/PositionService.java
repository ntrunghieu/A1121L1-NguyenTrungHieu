package casestudy.service.employee;

import casestudy.repository.employee.IPositionRepository;
import casestudy.entity.employee.Position;
import casestudy.service.employee.impl.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public Iterable<Position> findAll() {
        return iPositionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Long id) {
        return iPositionRepository.findById(id);
    }
}
