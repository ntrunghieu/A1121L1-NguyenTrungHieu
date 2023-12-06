package module6.backend.controller;

import module6.backend.entity.customer.Customer;
import module6.backend.entity.material.Material;
import module6.backend.entity.material.MaterialType;
import module6.backend.service.ICustomerService;
import module6.backend.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("api/material")
public class MaterialController {
    @Autowired
    private IMaterialService materialService;

//    @GetMapping(value = "/list")
//    public ResponseEntity<Page<Material>> materialList (@PageableDefault(value = 3) Pageable pageable){
//        Page<Material> materials = this.materialService.findAll(pageable,);
//        if (materials.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(materials, HttpStatus.OK);
//    }
//    @GetMapping("/find-by-id/{id}")
//    public ResponseEntity<Material> findFloorsById(@PathVariable Integer id) {
//        return null;
//    }

//    @GetMapping("/list")
//    public ResponseEntity<Iterable<Material>> findAllMaterial(Pageable pageable,
//                                                              @RequestParam(defaultValue = "0") String search){
//        System.out.println(1);
//        List<Material> materialList = materialService.findAll(pageable, search).getContent();
//        if (materialList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(materialList, HttpStatus.OK);
//}


    /**
     * HieuCLh
     * Get ID Material
     */

    @GetMapping("detail/{id}")
    public ResponseEntity<Material> findMaterialById(@PathVariable("id") Long id) {
        Optional<Material> material = materialService.findById(id);

        if (material.isPresent()) {
            return new ResponseEntity<>(material.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * HieuCLH
     * List san pham moi
     */
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("detail")
    @ResponseStatus(HttpStatus.OK)
    public List<Material> getTopMaterial() {

        return materialService.findTopNewMaterial();
    }

    @Autowired
    private ICustomerService customerService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT', 'ROLE_SELL')")
    @PostMapping("/create")
    public ResponseEntity<Material> saveMaterial(@RequestBody Material material) {
        try {
            System.out.println(material.getMaterialCode());
            materialService.saveMaterial(material.getMaterialCode(), material.getMaterialName()
                    , material.getMaterialPrice(), material.getMaterialQuantity(), material.getMaterialExpiridate(),
                    material.getMaterialImage(), material.getMaterialDescribe(), material.getMaterialUnit(),
                    material.getMaterialTypeId().getMaterialTypeId(), material.getMaterialCustomerId().getCustomerId());
            return new ResponseEntity<>(material, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(material, HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT', 'ROLE_SELL')")
    @GetMapping("/getById/{id}")
    public ResponseEntity<Material> findById(@PathVariable("id") Long id) {
        Optional<Material> material = materialService.findById(id);
        return new ResponseEntity<>(material.get(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT', 'ROLE_SELL')")
    @PatchMapping("/update")
    public ResponseEntity<Material> findMaterialById(@RequestBody Material material) {
//       Material material = materialService.findById(id);
        System.out.println(material.getMaterialCode());
        materialService.updateMaterial(material.getMaterialCode(), material.getMaterialName(), material.getMaterialPrice(),
                material.getMaterialQuantity(), material.getMaterialExpiridate(),
                material.getMaterialImage(), material.getMaterialDescribe(), material.getMaterialUnit(), material.getMaterialTypeId().getMaterialTypeId(),
                material.getMaterialCustomerId().getCustomerId(), material.getMaterialId());
        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT', 'ROLE_SELL')")
    @GetMapping("customer/list")
    public ResponseEntity<List<Customer>> findAllCustomer() {
        List<Customer> customers = materialService.findAllCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT', 'ROLE_SELL')")
    @GetMapping("materialType/list")
    public ResponseEntity<List<MaterialType>> findAllMaterialType() {
        List<MaterialType> materialTypes = materialService.findAllMaterialType();
        System.out.println(materialTypes.size());
        return new ResponseEntity<>(materialTypes, HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT', 'ROLE_SELL')")
    @GetMapping
    public ResponseEntity<Page<Material>> findAllMaterial(@PageableDefault(size = 4) Pageable pageable,
                                                          @RequestParam(defaultValue = "") String search) {
        Page<Material> materialList = materialService.findAll(pageable, search);
        if (materialList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(materialList, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT', 'ROLE_SELL')")
    @GetMapping("/delete/{id}")
    public ResponseEntity<Material> deleteMaterial(@PathVariable Long id) {
        Optional<Material> materialOptional = materialService.findById(id);
        if (!materialOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        materialService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Get list material.
     */
    @GetMapping("/list")
    public ResponseEntity<Page<Material>> getAllMaterial(@RequestParam("page") Integer page,
                                                         @RequestParam("size") Integer size) {

        Page<Material> materials = materialService.getAllMaterial(page, size);
        return new ResponseEntity<>(materials, HttpStatus.OK);
    }

    /**
     * Get list material.
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT', 'ROLE_SELL')")
    @GetMapping("/search")
    public ResponseEntity<Page<Material>> getAllMaterialSearch(@RequestParam("page") Integer page,
                                                               @RequestParam("size") Integer size, @RequestParam("search") String search) {

        Page<Material> materials = materialService.getAllMaterialSearch(search, page, size);
        return new ResponseEntity<>(materials, HttpStatus.OK);
    }

}


