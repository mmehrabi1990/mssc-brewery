package mehrabi.springframework.springframeworkwebservices.web.controller.v2;

import mehrabi.springframework.springframeworkwebservices.services.BeerService;
import mehrabi.springframework.springframeworkwebservices.services.v2.BeerServiceV2;
import mehrabi.springframework.springframeworkwebservices.web.model.BeerDTO;
import mehrabi.springframework.springframeworkwebservices.web.model.v2.BeerDTOV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTOV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> handlePost(@RequestBody BeerDTOV2  beerDTOV2){
        BeerDTOV2 savedBeer = beerServiceV2.saveNewBeer(beerDTOV2);

        HttpHeaders headers  =  new HttpHeaders();

        headers.add("Location","/api/v1/beer/"+savedBeer.getId().toString());

        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<HttpStatus> handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDTOV2 beerDTO){

        beerServiceV2.updateBeer(beerId,beerDTO);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeerById(beerId);
    }
}
