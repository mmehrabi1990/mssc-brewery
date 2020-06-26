package mehrabi.springframework.springframeworkwebservices.services;

import mehrabi.springframework.springframeworkwebservices.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().beerName("Galaxy Cat").id(UUID.randomUUID()).beerStyle("Pale Ale").build();
    }
}
