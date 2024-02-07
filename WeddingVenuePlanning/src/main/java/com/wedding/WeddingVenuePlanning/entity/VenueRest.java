package com.wedding.WeddingVenuePlanning.entity;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class VenueRest {

    @NonNull
    private int venueId;
    @NonNull
    @Size(min = 2, max = 20, message = "Venue name can not exceed 20 character")
    private  String venueName;

    @NonNull
    private  String venueType;
    @NonNull
    private String venueAddress;

    @NonNull
    @PastOrPresent(message = "Date should not be in Furute")
    private LocalDate createdDate;


    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
