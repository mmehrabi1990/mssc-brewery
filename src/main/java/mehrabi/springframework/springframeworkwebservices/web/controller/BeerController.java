package mehrabi.springframework.springframeworkwebservices.web.controller;

import mehrabi.springframework.springframeworkwebservices.services.BeerService;
import mehrabi.springframework.springframeworkwebservices.web.model.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @deprecated (when, why, refactoring advice...)
 */
@Deprecated(since = "v1.2",forRemoval = true)

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> handlePost(@Valid @RequestBody BeerDTO  beerDTO){
        BeerDTO savedBeer = beerService.saveNewBeer(beerDTO);

        HttpHeaders headers  =  new HttpHeaders();

        headers.add("Location","/api/v1/beer/"+savedBeer.getId().toString());

        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<HttpStatus> handleUpdate(@PathVariable("beerId") UUID beerId,@Valid @RequestBody BeerDTO beerDTO){

        beerService.updateBeer(beerId,beerDTO);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeerById(beerId);
    }
}
