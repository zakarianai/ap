package org.parking.gestio_parking.mappers;

import org.parking.gestio_parking.Dto.ClientDto;
import org.parking.gestio_parking.entities.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ClientMappers {
    public ClientDto fromClient(Client client){
        ClientDto clientDto= new ClientDto();
        BeanUtils.copyProperties(client,clientDto);
        return clientDto;

    }
    public Client fromClientDto(ClientDto clientDto){
        System.out.println("Nom : fromClientDto "+clientDto.getNom());
        Client client=new Client();
        BeanUtils.copyProperties(clientDto,client);
        return client;


    }

}
