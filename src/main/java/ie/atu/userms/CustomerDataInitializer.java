package ie.atu.userms;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataInitializer implements CommandLineRunner {

    private final CustomerService customerService;

    public CustomerDataInitializer(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) {
        // Add dummy customers on startup
        Customer dummyCustomer1 = new Customer();
        dummyCustomer1.setName("John Doe");
        dummyCustomer1.setCustomerId("C0001");
        dummyCustomer1.setAge(30);
        dummyCustomer1.setEmail("john.doe@hotmail.com");
        dummyCustomer1.setAddress("ABC Main Street");

        Customer dummyCustomer2 = new Customer();
        dummyCustomer2.setName("Jane Doe");
        dummyCustomer2.setCustomerId("C0002");
        dummyCustomer2.setAge(25);
        dummyCustomer2.setEmail("jane.doe@hotmail.com");
        dummyCustomer2.setAddress("XYZ Main Street");

        customerService.saveCustomer(dummyCustomer1);
        customerService.saveCustomer(dummyCustomer2);
    }
}