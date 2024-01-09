package ie.atu.userms;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Customer {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters")
    private String name;

    @NotBlank(message = "Customer ID cannot be blank")
    @Size(min = 5, max = 10, message = "Customer ID must be between 5 and 10 characters")
    private String customerId;

    @NotNull(message = "Age cannot be null")
    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 120, message = "Age must be less than or equal to 120")
    private Integer age;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Address cannot be blank")
    private String address;

}

