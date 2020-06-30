package mehrabi.springframework.springframeworkwebservices.web.mappers;

import mehrabi.springframework.springframeworkwebservices.domain.Customer;
import mehrabi.springframework.springframeworkwebservices.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO  customerToCustomerTDO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

}
