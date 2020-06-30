package mehrabi.springframework.springframeworkwebservices.web.mappers;

import mehrabi.springframework.springframeworkwebservices.domain.Beer;
import mehrabi.springframework.springframeworkwebservices.web.model.v2.BeerDTOV2;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDTOV2 beerToBeerDTO(Beer beer);

    Beer beerDTOToBeer(BeerDTOV2 beerDTOV2);
}
