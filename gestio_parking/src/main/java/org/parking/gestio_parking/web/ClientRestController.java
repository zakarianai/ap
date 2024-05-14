package org.parking.gestio_parking.web;

import lombok.AllArgsConstructor;
import org.parking.gestio_parking.Dto.ClientDto;
import org.parking.gestio_parking.Exceptions.ExceptionClientNotfound;
import org.parking.gestio_parking.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ClientRestController {
    private ClientService clientService;

    @GetMapping("/clients")
    public List<ClientDto> Clients(){
        return clientService.ListeClient();
    }
    @GetMapping("/cli")
    public void Cli(){
        System.out.println("sss");;
    }

    @GetMapping("/client/{id}")
    public ClientDto getclientbyid(@PathVariable(name= "id") int id ) throws ExceptionClientNotfound {
        return clientService.ClientById(id);
    }

    @PostMapping("/client")
    public ClientDto SaveClient(@RequestBody ClientDto clientDto){
        //System.out.println("le ==============================================="+clientDto.getNom());
        return clientService.SaveClient(clientDto);
    }

    @PutMapping("/client/{id}")
    public ClientDto update(@PathVariable int id ,@RequestBody ClientDto clientDto) throws ExceptionClientNotfound {

        return clientService.UpdateClient(id,clientDto);
    }
    @DeleteMapping("/client/{id}")
    public void delete(@PathVariable int id ){
        clientService.DeleteClient(id);
    }

}
