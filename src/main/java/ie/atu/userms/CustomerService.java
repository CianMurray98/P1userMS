package ie.atu.userms;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepo.findById(customerId);
    }

    public void updateCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public void deleteCustomerById(Long customerId) {
        customerRepo.deleteById(customerId);
    }
}