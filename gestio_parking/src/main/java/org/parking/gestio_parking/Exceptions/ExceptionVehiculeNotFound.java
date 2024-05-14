package org.parking.gestio_parking.Exceptions;

public class ExceptionVehiculeNotFound extends Exception {
    public ExceptionVehiculeNotFound(String vehiculeNotFound) {
        super(vehiculeNotFound);
    }
}
