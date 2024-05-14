package org.parking.gestio_parking.services;


import org.parking.gestio_parking.Dto.ClientDto;
import org.parking.gestio_parking.Exceptions.ExceptionClientNotfound;
import org.parking.gestio_parking.entities.Client;
import org.parking.gestio_parking.mappers.ClientMappers;
import org.parking.gestio_parking.repositories.Clientrepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional


public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMappers clientMappers;
    @Autowired
    private Clientrepository clientrepository;

    public ClientServiceImpl() {
    }

    public ClientServiceImpl(ClientMappers clientMappers, Clientrepository clientrepository) {
        this.clientMappers = clientMappers;
        this.clientrepository = clientrepository;
    }

    @Override
    public ClientDto SaveClient(ClientDto clientDto) {
        System.out.println("le nom"+clientDto.getNom());
        Client client = clientMappers.fromClientDto(clientDto);
        Client saveclient = clientrepository.save(client);
        return clientMappers.fromClient(saveclient);
    }

    @Override
    public ClientDto UpdateClient(int id, ClientDto clientDto) throws ExceptionClientNotfound {
        Client cid = clientrepository.findById(id).orElseThrow(()-> new ExceptionClientNotfound("client not found"));
        Client client =clientMappers.fromClientDto(clientDto);
        cid.setName(client.getName());
        cid.setAdresse_client(client.getAdresse_client());
        cid.setEmail(client.getEmail());
        cid.setPrenom(client.getPrenom());
        cid.setTelephone(client.getTelephone());
        cid.setNom_utilisateur(client.getNom_utilisateur());
        //Client saveclient = clientrepository.save(cid);
        return clientMappers.fromClient(cid);
    }

    @Override
    public void DeleteClient(int id) {
        clientrepository.deleteById(id);

    }

    @Override
    public List<ClientDto> ListeClient() {
        List<Client> listclient = clientrepository.findAll();
        List<ClientDto> list = listclient.stream().map(client-> clientMappers.fromClient(client)).collect(Collectors.toList());
        return list;
    }

    @Override
    public ClientDto ClientById(int id) throws ExceptionClientNotfound {
        Client clientByid = clientrepository.findById(id).orElseThrow(()-> new ExceptionClientNotfound("client not found"));
        ClientDto clientDto= clientMappers.fromClient(clientByid);
        return clientDto;
    }

    @Override
    public List<ClientDto> SearchClient(String name) {
        /*List<Client> listclient = clientrepository.listeClients(name);
        List<ClientDto> resultat = listclient.stream().map(client -> clientMappers.fromClient(client)).collect(Collectors.toList());
        return resultat;*/
        return null;
    }
}
