package module6.backend.controller;

import module6.backend.repository.ICartRepository;
import module6.backend.repository.ICustomerRepository;
import module6.backend.repository.IImportRepository;
import module6.backend.repository.IMaterialRepository;
import module6.backend.service.IStatisticService;
import module6.backend.service.Impl.pdf.PDFStatisticCustomerImpl;
import module6.backend.service.Impl.pdf.PDFStatisticFinancialServiceImpl;
import module6.backend.service.Impl.pdf.PDFStatisticFinancialServiceImpl2;
import module6.backend.service.Impl.pdf.PDFStatisticMaterialsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/statistic")
public class StatisticController {
    @Autowired
    private IStatisticService statisticService;

    @Autowired
    private PDFStatisticMaterialsImpl pdfStatisticMaterials;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IMaterialRepository materialRepository;

    @Autowired
    private PDFStatisticFinancialServiceImpl2 pdfStatisticFinancialServiceImpl2;
//    @Autowired
//    private IImportRepository iImportRepository;
//
//    @Autowired
//    private ICartRepository cartRepository;
//
//    @Autowired
//    private PDFStatisticFinancialServiceImpl pdfStatisticFinancialService;

    @Autowired
    private PDFStatisticCustomerImpl pdfStatisticCustomer;

    //HoangTND - Statistic Material
    //List material
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/list/material")
    public ResponseEntity<List<String>> data() {
        List<String> data = statisticService.findAllStatisticMaterial();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/list/material1")
    public ResponseEntity<String[]> data1() {
        String[] data = materialRepository.findAllStatisticMaterial1();
        return new ResponseEntity<String[]>(data, HttpStatus.OK);
    }

    //Search material
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/search/material")
    public ResponseEntity<List<String>> search(@RequestParam String fromDate, @RequestParam String toDate) {
        List<String> data = statisticService.searchStatisticMaterial(fromDate, toDate);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    //Print list material
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> generatePDFHoang() throws IOException {
        String[] data = materialRepository.findAllStatisticMaterial1();
        ByteArrayInputStream bais = pdfStatisticMaterials.export(data);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline;filename=cart.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }

    // KimPBH - Thong ke tai chinh
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/huyhang")
    public ResponseEntity<Integer> huyHang() {
        Integer huy = statisticService.displayHuy();
        return new ResponseEntity<>(huy, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/trahang")
    public ResponseEntity<Integer> traHang() {
        Integer tra = statisticService.displayTra();
        return new ResponseEntity<>(tra, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/banhang")
    public ResponseEntity<Integer> banHang() {
        Integer ban = statisticService.displayBan();
        return new ResponseEntity<>(ban, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/nhaphang")
    public ResponseEntity<Integer> nhapHang() {
        Integer nhap = statisticService.displayNhap();
        return new ResponseEntity<>(nhap, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/search")
    public ResponseEntity<Integer[]> huyHang(@RequestParam String month, @RequestParam String year) {
        if (month.equals("")) {
            month = "%" + month + "%";
        }
        year = "%" + year + "%";
        Integer huy = statisticService.searchHuy(month, year);
        if (huy == null) {
            huy = 0;
        }
        Integer tra = statisticService.searchTra(month, year);
        if (tra == null) {
            tra = 0;
        }
        Integer ban = statisticService.searchBan(month, year);
        if (ban == null) {
            ban = 0;
        }
        Integer nhap = statisticService.searchNhap(month, year);
        if (nhap == null) {
            nhap = 0;
        }
        Integer[] search = new Integer[4];
        search[0] = ban;
        search[1] = nhap;
        search[2] = huy;
        search[3] = tra;
        return new ResponseEntity<>(search, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @PostMapping("/pdf2")
    public ResponseEntity<InputStreamResource> generatePDFKim(@RequestBody String[] data) throws IOException {
        System.out.println(1);
        ByteArrayInputStream bais = pdfStatisticFinancialServiceImpl2.export(data);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline;filename=cart.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }
//    @GetMapping("/luongNV")
//    public ResponseEntity<Integer> luongNV() {
//        Integer luong = statisticService.displayLuong();
//        return new ResponseEntity<>(luong, HttpStatus.OK);
//    }

//    @PostMapping("/pdf")
//    public ResponseEntity<InputStreamResource> generatePDF() throws IOException {
//        String [] data = ICartRepository.ban1();
//        ByteArrayInputStream bais = pdfStatisticFinancialService.export(data);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition","inline;filename=financial.pdf");
//        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
//    }


    // HuyenNTD - Thong ke khach hang tiem nang
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/list/customer")
    public ResponseEntity<Page<String>> getAll(@PageableDefault(value = 5) Pageable pageable) {
        Page<String> list = statisticService.findAllStatisticCustomer(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @GetMapping("/list/customers")
//    public ResponseEntity<String[]> dataHuyen() {
//        String[] data = customerRepository.findAllPotentialCustomer();
//        return new ResponseEntity<String[]>(data, HttpStatus.OK);
//    }

    @GetMapping("/pdf-huyen")
    public ResponseEntity<InputStreamResource> generatePDFHuyen() throws IOException {
        String[] data = customerRepository.findAllPotentialCustomer();
        ByteArrayInputStream bais = pdfStatisticCustomer.export(data);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline;filename=cart.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/list/customers")
    public ResponseEntity<String[]> getAllCustomer() {
        String[] data = customerRepository.findAllPotentialCustomer();
        return new ResponseEntity<String[]>(data, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT')")
    @GetMapping("/search/customer")
    public ResponseEntity<String[]> searchPotentialCustomers(@RequestParam String fromMonth, @RequestParam String toMonth,
                                                             @RequestParam String year) {
        String[] list = statisticService.searchForPotentialCustomers(fromMonth, toMonth, year);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
