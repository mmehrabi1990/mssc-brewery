package mehrabi.springframework.springframeworkwebservices.web.controller;

import mehrabi.springframework.springframeworkwebservices.services.CustomerService;
import mehrabi.springframework.springframeworkwebservices.web.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> handlePost(@Valid @RequestBody CustomerDTO  customerDTO){
        CustomerDTO savedCustomer = customerService.saveNewCustomer(customerDTO);

        HttpHeaders headers  =  new HttpHeaders();

        headers.add("Location","/api/v1/customer/"+savedCustomer.getId().toString());

        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId,@Valid @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerId,customerDTO);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomerById(customerId);
    }

}
