package module6.backend;

import module6.backend.entity.customer.Customer;
import module6.backend.service.ICustomerService;
import module6.backend.service.Impl.CustomerServiceImpl;
import org.hibernate.usertype.CompositeUserType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class BackendApplicationTests {
    @Autowired
    ICustomerService customerService ;
    @Autowired
    private MockMvc mockMvc;

//    HieuNT test list customer
    @Test
    void contextLoads() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/customer"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    //    HieuNT test delete customer
    @Test
     void deleteCustomerById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/customer/customer-delete/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }





}
