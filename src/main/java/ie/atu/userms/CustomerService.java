package ie.atu.userms;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {
    private final Map<String, Customer> customerData = new HashMap<>();
    public CustomerService() {
        // Add a single person as dummy data
        Customer dummyCustomer = new Customer();
        dummyCustomer.setName("Cian Murray");
        dummyCustomer.setCustomerId("ABC12345");
        dummyCustomer.setAge(25);
        dummyCustomer.setEmail("CM98@gmail.com");
        dummyCustomer.setAddress("Ballintemple, Briarhill, Galway");

        customerData.put(dummyCustomer.getCustomerId(), dummyCustomer);
    }

    public void saveCustomer(Customer customer) {
        customerData.put(customer.getCustomerId(), customer);
        System.out.println("Person saved: " + customer);
    }

    public Customer getCustomerByCustomerId(String CustomerId) {
        return customerData.get(CustomerId);
    }
}