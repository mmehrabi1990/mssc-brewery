package mehrabi.springframework.springframeworkwebservices.services;

import mehrabi.springframework.springframeworkwebservices.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteBeerById(UUID beerId);
}
