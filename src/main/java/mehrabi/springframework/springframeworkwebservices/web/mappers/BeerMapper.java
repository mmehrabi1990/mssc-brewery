package mehrabi.springframework.springframeworkwebservices.web.mappers;

import mehrabi.springframework.springframeworkwebservices.domain.Beer;
import mehrabi.springframework.springframeworkwebservices.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDTO beerToBeerDTO(Beer beer);

    Beer beerDTOToBeer(BeerDTO beerDTOV2);
}
