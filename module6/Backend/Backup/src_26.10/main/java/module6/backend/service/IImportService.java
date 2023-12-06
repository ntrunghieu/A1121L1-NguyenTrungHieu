package module6.backend.service;

import module6.backend.entity.Import;
import module6.backend.entity.customer.Customer;
import module6.backend.entity.employee.Employee;
import module6.backend.entity.material.Material;
import module6.backend.entity.material.MaterialType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IImportService {
    Page<Import> findAllImport(Pageable page);

    List<String> findAllImportString();

    void deleteImport(Long idAfterUpdate, Boolean flag, Long idBeforeUpdate);

    Optional<Import> findImportById(Long id);

    void updateImport(Import importUpdate, Integer quantityBeforeUpdate);

    void createImport(Import importCreate, Material materialCreate, Customer customerCreate);

    Import findImportByCode(String importCode);

    List<Customer> findAllCustomerImport();

    List<Employee> findAllEmployeeImport();

    List<Material> findAllMaterialImport(Long customerId);

    List<String> findAllMaterialImportString();

    List<String> findAllCustomerImportString();

    List<String> findAllCustomerPhoneImportString();

    List<String> findAllCustomerEmailImportString();

    List<MaterialType> findAllMaterialTypeImport();

    Page<Import> searchImport(String code, String startDate, String endDate, Pageable page);

    Page<Import> searchImportCode(String code, Pageable page);
}
