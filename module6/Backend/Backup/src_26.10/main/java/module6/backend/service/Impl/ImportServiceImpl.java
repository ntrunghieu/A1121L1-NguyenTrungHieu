package module6.backend.service.Impl;

import module6.backend.entity.Import;
import module6.backend.entity.customer.Customer;
import module6.backend.entity.employee.Employee;
import module6.backend.entity.material.Material;
import module6.backend.entity.material.MaterialType;
import module6.backend.repository.*;
import module6.backend.service.IImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImportServiceImpl implements IImportService {
    @Autowired
    private IImportRepository importRepository;

    @Autowired
    private IMaterialRepository materialRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IMaterialTypeRepository materialTypeRepository;

    // Thắng code list import
    @Override
    public Page<Import> findAllImport(Pageable page) {
        return importRepository.findAllImport(page);
    }


    @Override
    public List<String> findAllImportString() {
        return importRepository.findAllImportString();
    }

    // Thắng code xoá import
    @Override
    public void deleteImport(Long idAfterUpdate, Boolean flag, Long idBeforeUpdate) {
        importRepository.deleteImport(idAfterUpdate, flag, idBeforeUpdate);
    }

    // Thắng tìm import theo id
    @Override
    public Optional<Import> findImportById(Long id) {
        return importRepository.findImportById(id);
    }

    // Thắng code update import
    @Override
    public void updateImport(Import importAfterUpdate, Integer importQuantityBeforeUpdate) {
        Integer quantityMaterial = importAfterUpdate.getImportMaterialId().getMaterialQuantity()
                - importQuantityBeforeUpdate
                + importAfterUpdate.getImportQuantity();
        if (quantityMaterial >= 0) {
            materialRepository.updateMaterialImport(importAfterUpdate.getImportMaterialId().getMaterialCode(), importAfterUpdate.getImportMaterialId().getMaterialName(), importAfterUpdate.getImportMaterialId().getMaterialUnit(), quantityMaterial, importAfterUpdate.getImportMaterialId().getMaterialId());
            importRepository.updateImport(importAfterUpdate.getImportCode(), importAfterUpdate.getImportStartDate(), importAfterUpdate.getImportQuantity(), importAfterUpdate.getImportAccountId().getAccountId(), importAfterUpdate.getImportMaterialId().getMaterialId(), importAfterUpdate.getImportId());
        }
    }

    // Thắng code create import
    @Override
    public void createImport(Import importCreate, Material materialCreate, Customer customerCreate) {
        Integer quantity = importCreate.getImportMaterialId().getMaterialQuantity() + importCreate.getImportQuantity();

        if (customerRepository.findByCustomerCode(customerCreate.getCustomerCode()) == null) {
            customerRepository.createCustomerImport(customerCreate.getCustomerName(), customerCreate.getCustomerCode(), customerCreate.getCustomerAddress(), customerCreate.getCustomerPhone(), customerCreate.getCustomerEmail(), customerCreate.getCustomerTypeId().getCustomerTypeId(), customerCreate.getCustomerAvatar());
            Customer customer = customerRepository.findByCustomerCode(customerCreate.getCustomerCode());

            materialCreate.setMaterialCustomerId(customer);

            materialRepository.createMaterialImport(materialCreate.getMaterialCode(), materialCreate.getMaterialName(), quantity, materialCreate.getMaterialPrice(), materialCreate.getMaterialExpiridate(), materialCreate.getMaterialUnit(), materialCreate.getMaterialTypeId().getMaterialTypeId(), materialCreate.getMaterialCustomerId().getCustomerId(), materialCreate.getMaterialImage(), materialCreate.getMaterialDescribe());
            Material material = materialRepository.findByMaterialCode(materialCreate.getMaterialCode());
            importRepository.createImport(importCreate.getImportCode(), importCreate.getImportStartDate(), importCreate.getImportQuantity(), importCreate.getImportAccountId().getAccountId(), material.getMaterialId());

        } else if (materialRepository.findByMaterialCode(materialCreate.getMaterialCode()) == null) {
            materialRepository.createMaterialImport(materialCreate.getMaterialCode(), materialCreate.getMaterialName(), quantity, materialCreate.getMaterialPrice(), materialCreate.getMaterialExpiridate(), materialCreate.getMaterialUnit(), materialCreate.getMaterialTypeId().getMaterialTypeId(), customerCreate.getCustomerId(), materialCreate.getMaterialImage(), materialCreate.getMaterialDescribe());
            Material material = materialRepository.findByMaterialCode(materialCreate.getMaterialCode());
            importRepository.createImport(importCreate.getImportCode(), importCreate.getImportStartDate(), importCreate.getImportQuantity(), importCreate.getImportAccountId().getAccountId(), material.getMaterialId());
        } else {
            importCreate.getImportMaterialId().setMaterialQuantity(quantity);
            materialRepository.save(importCreate.getImportMaterialId());
            importRepository.createImport(importCreate.getImportCode(), importCreate.getImportStartDate(), importCreate.getImportQuantity(), importCreate.getImportAccountId().getAccountId(), importCreate.getImportMaterialId().getMaterialId());
        }
    }

    // Thắng tìm kiếm import theo code
    @Override
    public Import findImportByCode(String importCode) {
        return importRepository.findImportByCode(importCode);
    }

    // Thắng code lấy list nhà cung cấp
    @Override
    public List<Customer> findAllCustomerImport() {
        return customerRepository.findAllCustomerImport();
    }

    // Thắng code lấy list Employee để lấy tên Người thực hiện
    @Override
    public List<Employee> findAllEmployeeImport() {
        return employeeRepository.findAllEmployeeImport();
    }

    // Thắng code list material theo customer_id
    @Override
    public List<Material> findAllMaterialImport(Long customerId) {
        return materialRepository.findAllMaterialImport(customerId);
    }

    // Thắng code
    @Override
    public List<String> findAllMaterialImportString() {
        return materialRepository.findAllMaterialImportString();
    }

    @Override
    public List<String> findAllCustomerImportString() {
        return customerRepository.findAllCustomerImportString();
    }

    @Override
    public List<String> findAllCustomerPhoneImportString() {
        return customerRepository.findAllCustomerPhoneImportString();
    }

    @Override
    public List<String> findAllCustomerEmailImportString() {
        return customerRepository.findAllCustomerEmailImportString();
    }

    // Thắng code list material type
    @Override
    public List<MaterialType> findAllMaterialTypeImport() {
        return materialTypeRepository.findAllMaterialTypeImport();
    }

    // Thắng code search import có theo ngày
    @Override
    public Page<Import> searchImport(String code, String startDate, String endDate, Pageable page) {
        return importRepository.searchImport("%" + code + "%", startDate, endDate, page);
    }

    // thắng code
    @Override
    public Page<Import> searchImportCode(String code, Pageable page) {
        return importRepository.searchImportCode("%" + code + "%", page);
    }
}
