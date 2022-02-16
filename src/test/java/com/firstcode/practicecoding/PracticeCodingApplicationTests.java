package com.firstcode.practicecoding;

import com.firstcode.practicecoding.Repositories.Repository;
import com.firstcode.practicecoding.controllers.CustomerRestController2;
import com.firstcode.practicecoding.entities.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class PracticeCodingApplicationTests {

    @Autowired
    CustomerRestController2 customerCont;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private Repository repo;


    @Test
    void contextLoads() throws Exception{
        assertThat(customerCont).isNotNull();
    }
    @Test
    void injectedComponentsAreNotNull(){
        assertThat(repo).isNotNull();
    }

    @Test
    void textTest(){
        String s =customerCont.text();
        assertEquals("text",s);

    }
    @Test
    void updateTest(){
        Customer cus = new Customer(9,"IND3","india","urban");
        String s =customerCont.updateCustomer(cus);
        assertEquals("saved",s);
    }

    @Test
    void saveTest(){
        Customer cu = new Customer(6,"IND2","india","urban");
        repo.save(cu);
        assertThat(cu.getId()).isGreaterThan(0);
    }

    @Test
    void saveCustomerTest() {
        Customer cus = new Customer(7,"IND3","india","urban");
        when(repo.save(cus)).thenReturn(cus);
        assertEquals("Added", customerCont.saveCustomer(cus));
    }
    @Test
    public void getAllCustomers() throws Exception {
        this.mockMvc.perform(get("/Customer")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("india")));
    }
//    @Test
//    void saveTest3() {
//        Customer cus = new Customer(10,"IND3","india","urban");
//        when(repo.save(cus)).thenReturn(cus);
//        assertEquals("save", customerCont.save(cus).getName());
//    }


//    @Test
//    void check() {
//        Customer cust = new Customer(9,"IND3","india","urban");
//        doNothing().when(customerCont).updateCustomer(cust);
//        verify(customerCont,times(1));


//        Customer cust = new Customer(8,"IND3","india","urban");
//        doNothing().when(customerCont.updateCustomer(cust)).;
//        information.sendInfoForPublishing(person);
//        verify(publishing,times(1)).publishInformation(person);
//    }

}
