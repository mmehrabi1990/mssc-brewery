package mehrabi.springframework.springframeworkwebservices.services.v2;

import mehrabi.springframework.springframeworkwebservices.web.model.v2.BeerDTOV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDTOV2 getBeerById(UUID beerId);

    BeerDTOV2 saveNewBeer(BeerDTOV2 beerDTOV2);

    void updateBeer(UUID beerId, BeerDTOV2 beerDTOV2);

    void deleteBeerById(UUID beerId);
}
