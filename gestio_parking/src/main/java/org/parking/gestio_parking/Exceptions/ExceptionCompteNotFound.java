package org.parking.gestio_parking.Exceptions;

public class ExceptionCompteNotFound extends Exception {
    public ExceptionCompteNotFound(String compteNotFound) {
        super(compteNotFound);
    }
}
