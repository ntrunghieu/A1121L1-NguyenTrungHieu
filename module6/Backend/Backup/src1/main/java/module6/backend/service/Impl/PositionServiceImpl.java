package module6.backend.service.Impl;

import module6.backend.repository.IPositionRepository;
import module6.backend.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
}
