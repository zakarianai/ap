package org.parking.gestio_parking.Exceptions;

public class ExceptionResrvationNotFound extends Exception {
    public ExceptionResrvationNotFound(String resvationNotFound) {
        super(resvationNotFound);
    }
}
