package org.parking.gestio_parking.services;

import org.parking.gestio_parking.Dto.AdminDto;
import org.parking.gestio_parking.Dto.ClientDto;
import org.parking.gestio_parking.Exceptions.ExceptionAdminNotFound;

import java.util.List;

public interface AdminService {
    AdminDto SaveAdmin(AdminDto adminDto);
    AdminDto UpdateAdmin(int id , AdminDto adminDto) throws ExceptionAdminNotFound;
    void DeleteAdmin (int id);
    List<AdminDto> ListeAdmin ();
    AdminDto AdminById(int id) throws ExceptionAdminNotFound;
}
