package ie.atu.userms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Validated
@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerByCustomerId(
            @PathVariable @NotBlank(message = "Customer ID cannot be blank") Long customerId) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(customerId);

        return optionalCustomer.map(customer ->
                        new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>("Customer created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(@RequestBody @Valid Customer customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable @NotBlank(message = "Customer ID cannot be blank") Long customerId) {
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
    }
}