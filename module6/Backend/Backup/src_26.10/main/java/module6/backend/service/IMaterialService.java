package module6.backend.service;

import module6.backend.entity.customer.Customer;
import module6.backend.entity.material.Material;
import module6.backend.entity.material.MaterialType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IMaterialService {
    Optional<Material> findById(Long id);

    List<Material> findTopNewMaterial();

    Page<Material> findAll(Pageable pageable, String search);

    void deleteById(Long id);

    Page<Material> getAllMaterialSearch(String search, Integer page, Integer size);

    Page<Material> getAllMaterial(Integer page, Integer size);

    void saveMaterial(String code, String name, Double price, Integer quantity, LocalDate hsd,String img,String des, String unit, Long typeId, Long customerId);
    List<Customer> findAllCustomer();
    List<MaterialType> findAllMaterialType();
    void updateMaterial(String code, String name, Double price, Integer quantity, LocalDate hsd, String img,String des , String unit, Long typeId, Long customerId, Long materialId);
//    void saveMaterial(String code, String name, Integer quantity, Double price, LocalDate hsd, String unit, Long typeId, Long customerId);
//
//    List<Customer> findAllCustomer();
//
//    List<MaterialType> findAllMaterialType();
//
//    void updateMaterial(String code, String name, Double price, Integer quantity, LocalDate hsd, String unit, String img, String des, Long typeId, Long customerId, Long materialId);
}
