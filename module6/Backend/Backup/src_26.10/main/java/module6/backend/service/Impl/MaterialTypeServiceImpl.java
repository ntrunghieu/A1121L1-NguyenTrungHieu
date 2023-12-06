package module6.backend.service.Impl;


import module6.backend.entity.material.Material;
import module6.backend.entity.material.MaterialType;
import module6.backend.repository.IMaterialTypeRepository;
import module6.backend.service.IMaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialTypeServiceImpl implements IMaterialTypeService {
    @Autowired
    private IMaterialTypeRepository materialTypeRepository;

    @Override
    public List<MaterialType> findAll() {
        return materialTypeRepository.findAll();
    }

}


