package mehrabi.springframework.springframeworkwebservices.services;

import lombok.extern.slf4j.Slf4j;
import mehrabi.springframework.springframeworkwebservices.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().beerName("Galaxy Cat").id(UUID.randomUUID()).beerStyle("Pale Ale").build();
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return BeerDTO.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {

    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting a Beer");
    }
}
