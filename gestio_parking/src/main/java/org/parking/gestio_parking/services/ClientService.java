package org.parking.gestio_parking.services;

import org.parking.gestio_parking.Dto.ClientDto;
import org.parking.gestio_parking.Exceptions.ExceptionClientNotfound;

import java.util.List;

public interface ClientService {
    ClientDto SaveClient(ClientDto clientDto);


    ClientDto UpdateClient(int id, ClientDto clientDto) throws ExceptionClientNotfound;

    void DeleteClient (int id);
    List<ClientDto> ListeClient();
    ClientDto ClientById(int id) throws ExceptionClientNotfound;
    List<ClientDto> SearchClient(String name);



}
