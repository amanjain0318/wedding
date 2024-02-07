package com.wedding.WeddingVenuePlanning.exception;

public class NoRecordFoundException  extends RuntimeException{
    public NoRecordFoundException(String venuesAreNotAvailable) {
        super(venuesAreNotAvailable);
    }
}
