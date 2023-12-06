package module6.backend.service.Impl;

import module6.backend.entity.employee.Position;
import module6.backend.repository.IPositionRepository;
import module6.backend.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAllPosition();
    }

    @Override
    public List<Position> findPositionNotManager() {
        return positionRepository.findPositionNotManager();
    }
}
