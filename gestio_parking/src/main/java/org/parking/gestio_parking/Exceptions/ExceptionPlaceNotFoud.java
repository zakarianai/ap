package org.parking.gestio_parking.Exceptions;

public class ExceptionPlaceNotFoud extends Exception {
    public ExceptionPlaceNotFoud(String placeNotFound) {
        super(placeNotFound);
    }
}
