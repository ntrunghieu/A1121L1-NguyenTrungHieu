package exam.controller;

import exam.entity.TinTuc;
import exam.service.tintuc.impl.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TinTucControllerRest {

    @Autowired
    private ITinTucService tinTucService;

    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<TinTuc> delete(@PathVariable Long id) {
        Optional<TinTuc> employeeOptional = tinTucService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tinTucService.remove(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.NO_CONTENT);
    }

//        @GetMapping("/tintuc/search")
//    public ResponseEntity<List<TinTuc>> search(String name, Pageable pageable){
//        List<TinTuc> employees = tinTucService.findAllByTieuDeContaining(name,pageable);
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }

//    @GetMapping("/tintuc/search/{search}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<TinTuc>> searchCustomer(@PathVariable String search, Pageable pageable) {
////        if (name.equals("")){
////            return  iCustomerService.findAllAPI(pageable);
////        }
////        return iCustomerService.findAllByCustomerNameContaining(name,pageable);
////    }
//        List<TinTuc> list =tinTucService.findAllByTieuDeContaining(search, pageable);
//        List<TinTuc> list1 =tinTucService.findAllAPI(pageable);
//
//        if (search == null) {
//            search = "";
//        }
//        if (search.equals("")) {
////            return tinTucService.findAllByTieuDeContaining(name, pageable);
//            return new ResponseEntity<>(list1, HttpStatus.OK);        }
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
}
