package mehrabi.springframework.springframeworkwebservices.services.v2;

import lombok.extern.slf4j.Slf4j;
import mehrabi.springframework.springframeworkwebservices.web.model.v2.BeerDTOV2;
import mehrabi.springframework.springframeworkwebservices.web.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDTOV2 getBeerById(UUID beerId) {
        return BeerDTOV2.builder().beerName("Galaxy Cat").id(UUID.randomUUID()).beerStyle(BeerStyleEnum.ALE).build();
    }

    @Override
    public BeerDTOV2 saveNewBeer(BeerDTOV2 beerDTOV2) {
        return BeerDTOV2.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOV2 beerDTO) {
        //for sample
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting a Beer");
    }
}
