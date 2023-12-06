package module6.backend.controller;

import module6.backend.entity.customer.Customer;
import module6.backend.service.ICustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(CustomerController.class)
class CustomerController_Delete {
    @Autowired
    private MockMvc mockMvc;
//     [id] = null

    @MockBean
    private ICustomerService customerService;

    @Test
     void getAllCustomer() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/customer"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
     void deleteCustomerById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/customer/customer-delete/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
