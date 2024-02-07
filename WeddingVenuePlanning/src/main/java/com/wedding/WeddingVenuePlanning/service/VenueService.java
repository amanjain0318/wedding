package com.wedding.WeddingVenuePlanning.service;


import com.wedding.WeddingVenuePlanning.entity.VenueRest;

import java.util.List;

public interface VenueService {


    public VenueRest addVenue(VenueRest venueRest);

    List<VenueRest> getVenue();

    VenueRest getVenueById(int venueId);

    void deleteVenueById(int id);

    VenueRest updateVenueById(VenueRest venueRest);
}
