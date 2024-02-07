package com.wedding.WeddingVenuePlanning.controller;

import com.wedding.WeddingVenuePlanning.entity.VenueRest;
import com.wedding.WeddingVenuePlanning.service.VenueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class VenueRestController {

    @Autowired
    private VenueService venueService;

    @PostMapping("/venues")
    public ResponseEntity<VenueRest> addVenueDetails(@Valid  @RequestBody VenueRest venueRest)
    {
        VenueRest venueRestResult  =    venueService.addVenue(venueRest);
        return ResponseEntity.status(HttpStatus.CREATED).body(venueRest);
    }

    @GetMapping("/venues")
    public ResponseEntity<List<VenueRest>> getVenueDetails()
    {
        List<VenueRest> venueRestResultList  =    venueService.getVenue();
        return ResponseEntity.status(HttpStatus.OK).body(venueRestResultList);
    }

    @GetMapping("/venues/{id}")
    public ResponseEntity<VenueRest> getVenueDetails(@PathVariable int id)
    {
        VenueRest venueRestResult =    venueService.getVenueById(id);
        return ResponseEntity.status(HttpStatus.OK).body(venueRestResult);
    }

    @DeleteMapping("/venues/{id}")
    public ResponseEntity<String> deleteVenueDetails(@PathVariable int id)
    {
        venueService.deleteVenueById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Venue Deleted Successfully");
    }

    @PutMapping("/venues")
    public ResponseEntity<VenueRest> updateVenueDetails(@Valid @RequestBody VenueRest venueRest)
    {
        VenueRest venueRestResult =    venueService.updateVenueById(venueRest);
        return ResponseEntity.status(HttpStatus.OK).body(venueRestResult);
    }
}
