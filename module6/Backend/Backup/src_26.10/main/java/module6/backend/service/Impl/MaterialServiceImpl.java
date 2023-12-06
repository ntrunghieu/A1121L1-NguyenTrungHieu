package module6.backend.service.Impl;

import module6.backend.entity.customer.Customer;
import module6.backend.entity.material.Material;
import module6.backend.entity.material.MaterialType;
import module6.backend.repository.ICustomerRepository;
import module6.backend.repository.IMaterialRepository;
import module6.backend.repository.IMaterialTypeRepository;
import module6.backend.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements IMaterialService {
    @Autowired
    private IMaterialRepository materialRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IMaterialTypeRepository materialTypeRepository;

    //    @Override
//    public void saveMaterial(String code, String name, Integer quantity, Double price, LocalDate hsd, String unit, Long typeId, Long customerId) {
//        materialRepository.createMaterial(code, name, quantity, price, hsd, unit, typeId, customerId);
//    }
//
//    @Override
//    public List<Customer> findAllCustomer() {
//        return customerRepository.findAll();
//    }
//
//    @Override
//    public List<MaterialType> findAllMaterialType() {
//        return materialTypeRepository.findAll();
//    }
//
//    @Override
//    public void updateMaterial(String code, String name, Double price, Integer quantity, LocalDate hsd, String unit, String img, String des, Long typeId, Long customerId, Long materialId) {
//        materialRepository.updateMaterial(code, name, price, quantity, hsd, unit, img, des, typeId, customerId, materialId);
//    }
    @Override
    public void saveMaterial(String code, String name, Double price, Integer quantity, LocalDate hsd, String img, String des, String unit, Long typeId, Long customerId) {
        materialRepository.createMaterialImport(code, name, price, quantity, hsd, img, des, unit, typeId, customerId);
    }


    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<MaterialType> findAllMaterialType() {
        return materialTypeRepository.findAll();
    }

    @Override
    public void updateMaterial(String code, String name, Double price, Integer quantity, LocalDate hsd, String img, String des, String unit, Long typeId, Long customerId, Long materialId) {
        materialRepository.updateMaterialImport(code, name, price, quantity, hsd, img, des, unit, typeId, customerId, materialId);
    }

    @Override
    public Optional<Material> findById(Long id) {
        return materialRepository.findById(id);
    }

    @Override

    public List<Material> findTopNewMaterial() {
        return materialRepository.findTopNewMaterial();
    }


    public Page<Material> findAll(Pageable pageable, String search) {
        return materialRepository.findAll(pageable, search);
    }


    @Override
    public void deleteById(Long id) {
        materialRepository.deleteById(id);

    }

    public Page<Material> getAllMaterialSearch(String search, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return materialRepository.findAllByMaterial("%" + search + "%", paging);
    }

    @Override
    public Page<Material> getAllMaterial(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size, Sort.by("materialId").descending());
        return materialRepository.findAll(paging);
    }

//    @Override
//    public Optional<Material> findById(Long id) {
//        return materialRepository.findById(id);
//    }
//
//    @Override
//    public Page<Material> findAll(Pageable pageable, String search) {
//        return materialRepository.findAll(pageable, search);
//    }

}
