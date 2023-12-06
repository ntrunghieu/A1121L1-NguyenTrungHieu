package module6.backend.service.Impl;

import module6.backend.repository.IMaterialRepository;
import module6.backend.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements IMaterialService {
    @Autowired
    private IMaterialRepository materialRepository;
}
