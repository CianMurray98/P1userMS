package ie.atu.userms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService CustomerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid Customer customer) {
        CustomerService.saveCustomer(customer);
        return new ResponseEntity<>("Customer created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerByCustomerId(
            @PathVariable @NotBlank(message = "Customer ID cannot be blank") String customerId) {
        Customer customer = CustomerService.getCustomerByCustomerId(customerId);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}