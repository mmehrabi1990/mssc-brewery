package mehrabi.springframework.springframeworkwebservices.services;

import mehrabi.springframework.springframeworkwebservices.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);
}
