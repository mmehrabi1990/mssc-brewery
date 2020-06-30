package mehrabi.springframework.springframeworkwebservices.web.controller.v2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import mehrabi.springframework.springframeworkwebservices.services.v2.BeerServiceV2;
import mehrabi.springframework.springframeworkwebservices.web.model.v2.BeerDTOV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequestMapping("/api/v2/beer")
@RestController
@Validated
@AllArgsConstructor
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTOV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> handlePost(@Valid @NotNull @RequestBody BeerDTOV2  beerDTOV2){
        val savedBeer = beerServiceV2.saveNewBeer(beerDTOV2);

        var headers  =  new HttpHeaders();

        headers.add("Location","/api/v1/beer/"+savedBeer.getId().toString());

        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<HttpStatus> handleUpdate(@NotNull @PathVariable("beerId") UUID beerId,@Valid @NotNull @RequestBody BeerDTOV2 beerDTO){

        beerServiceV2.updateBeer(beerId,beerDTO);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@NotNull @PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeerById(beerId);
    }

}
