package com.wedding.WeddingVenuePlanning.serviceimpl;

import com.wedding.WeddingVenuePlanning.entity.VenueRest;
import com.wedding.WeddingVenuePlanning.exception.NoRecordFoundException;
import com.wedding.WeddingVenuePlanning.service.VenueService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VenueServiceImpl implements VenueService{

    List<VenueRest> venueRestList ;
    @PostConstruct
    public void init()
    {
        venueRestList =  new ArrayList<>();
    }

    @Override
    public VenueRest addVenue(VenueRest venueRest) {

        venueRestList.add(venueRest);
        return venueRest;

    }

    @Override
    public List<VenueRest> getVenue() {
        return venueRestList;
    }

    @Override
    public VenueRest getVenueById(int venueId) {
        return venueRestList.stream()
                .filter(data ->  data.getVenueId()==venueId)
                .findFirst()
                .orElseThrow(() -> new NoRecordFoundException("Venues are not Available"));
    }

    @Override
    public void deleteVenueById(int id) {
        venueRestList.removeIf(venueRest -> venueRest.getVenueId() == id);
    }

    @Override
    public VenueRest updateVenueById(VenueRest venueRest) {
       return venueRestList.stream()
                .filter(data -> data.getVenueId()==venueRest.getVenueId())
                .map(venue -> {
                    venue.setVenueId(venueRest.getVenueId());
                    venue.setVenueName(venueRest.getVenueName());
                    venue.setVenueAddress(venueRest.getVenueAddress());
                    venue.setVenueType(venueRest.getVenueType());
                    venue.setCreatedDate(venueRest.getCreatedDate());
                    return venue;
                }).findFirst().orElseThrow(() -> new NoRecordFoundException("Venue not Found"));

    }


}
