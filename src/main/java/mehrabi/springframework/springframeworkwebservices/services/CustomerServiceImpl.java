package mehrabi.springframework.springframeworkwebservices.services;

import mehrabi.springframework.springframeworkwebservices.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID()).customerName("joe Buck").build();
    }
}
