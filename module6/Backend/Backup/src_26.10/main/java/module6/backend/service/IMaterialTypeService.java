package module6.backend.service;

import module6.backend.entity.material.MaterialType;

import java.util.List;

public interface IMaterialTypeService {
    List<MaterialType> findAll();
}
